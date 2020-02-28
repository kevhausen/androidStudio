package cl.desafiolatam.preguntadinamica;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private TextView question, category, difficulty;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button button;

    public FirstFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        Log.e("Error","En FirstFragment");
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_first, container, false);
        initializeViews(view);

        question.setText(mParam1);
        category.setText(mParam2);

      button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Toast.makeText(getContext(), "Holanda", Toast.LENGTH_SHORT).show();
              pasarAlotro();

          }
      });

        return view;
    }

    private void initializeViews(View view){
        question = view.findViewById(R.id.question);
        category = view.findViewById(R.id.category);
        difficulty = view.findViewById(R.id.difficulty);
        button =  view.findViewById(R.id.buttonInFragment1);
    }


private void pasarAlotro(){

    SecondFragment secondFragment = SecondFragment.newInstance("","");
   getActivity().getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.frameLayout, secondFragment, "SECONDFRAGMENT")
           .addToBackStack("SecondFragment")
            .commit();
}
}
