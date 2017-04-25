package pe.edu.lsc.familialaureana.view.Padre;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pe.edu.lsc.familialaureana.R;

/**
 * Created by karina on 29/03/17.
 */

public class chat extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.chat, container, false);
        return rootView;
    }
}
