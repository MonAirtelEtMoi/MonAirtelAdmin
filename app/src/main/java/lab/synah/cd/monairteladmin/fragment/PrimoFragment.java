package lab.synah.cd.monairteladmin.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import lab.synah.cd.monairteladmin.AdminActivity;
import lab.synah.cd.monairteladmin.R;

/**
 * Created by Michelo on 06/01/16.
 */
public class PrimoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //inflate here
        final View view = inflater.inflate(R.layout.main_fragment, container, false);
        ((AdminActivity) getActivity()).getSupportActionBar().setTitle("USSD");

        Button buttonChangeText = (Button) view.findViewById(R.id.buttonFragmentInbox);
        final TextView textViewStudentFragment = (TextView) view.findViewById(R.id.textViewInboxFragment);

        buttonChangeText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                textViewStudentFragment.setText("Ceci marche très bien");
                textViewStudentFragment.setTextColor(getResources().getColor(R.color.colorAccent));

            }
        });

        return view;

    }
}