package lab.synah.cd.monairteladmin.fragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.ui.FirebaseListAdapter;

import lab.synah.cd.monairteladmin.R;
import lab.synah.cd.monairteladmin.model.Ussd;
import lab.synah.cd.monairteladmin.utils.Config;

/**
 * Created by Michelo on 13/01/16.
 */
public class TestListFragment extends ListFragment {

    private Firebase mFireBaseRef; //Firebase reference
    FirebaseListAdapter<Ussd> mListAdapter; //To be used when retreiving data in the list


    public TestListFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Firebase.setAndroidContext(getActivity());

        mFireBaseRef=new Firebase(Config.FIREBASE_URL).child(Config.USSD_CHILD);

       // View rootView = inflater.inflate(R.layout.fragment_ussd, container, false);
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_ussd, container, false);

        final EditText textEdit = (EditText) rootView.findViewById(R.id.text_edit);
        final EditText textUssd = (EditText) rootView.findViewById(R.id.text_ussd);

        Button sendButton = (Button) rootView.findViewById(R.id.send_button);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ussd=textUssd.getText().toString();
                String text = textEdit.getText().toString();

                /*
                // This method is used in case we have not a class model

                Map<String,Object> values=new HashMap<>();
                values.put("name","Code USSD");
                values.put("text",text);

                */

                Ussd codeussd = new Ussd(ussd, text);
                mFireBaseRef.push().setValue(codeussd);
                textUssd.setText((""));
                textEdit.setText((""));
            }
        });

        mListAdapter = new FirebaseListAdapter<Ussd>(getActivity(), Ussd.class, android.R.layout.two_line_list_item, mFireBaseRef) {
            @Override
            protected void populateView(View v, Ussd model) {
                ((TextView) v.findViewById(android.R.id.text1)).setText(model.getName());
                ((TextView) v.findViewById(android.R.id.text2)).setText(model.getText());
            }
        };
        setListAdapter(mListAdapter);

        setRetainInstance(true);
        return rootView;
    }


    public void onListItemClick(ListView listView, View view, int position, long id){
        ViewGroup viewGroup=(ViewGroup)view;
        TextView txt=(TextView)viewGroup.findViewById(R.id.ussd);
        Toast.makeText(getActivity(),txt.getText().toString(),Toast.LENGTH_LONG).show();
    }
}
