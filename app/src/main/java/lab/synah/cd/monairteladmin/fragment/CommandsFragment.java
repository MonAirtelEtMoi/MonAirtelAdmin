package lab.synah.cd.monairteladmin.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lab.synah.cd.monairteladmin.R;

/**
 * Created by Michelo on 13/01/16.
 */
public class CommandsFragment extends Fragment {

    public CommandsFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        return rootView;
    }
}
