package com.example.amit.kohinoor_applicationn.FRAGMENT;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.amit.kohinoor_applicationn.ACTIVITIES.CompanyActivity;
import com.example.amit.kohinoor_applicationn.ACTIVITIES.MachineryActivity;
import com.example.amit.kohinoor_applicationn.ACTIVITIES.MaterialActivity;
import com.example.amit.kohinoor_applicationn.ACTIVITIES.SiteActivity;
import com.example.amit.kohinoor_applicationn.ACTIVITIES.SubMaterialActivity;
import com.example.amit.kohinoor_applicationn.ACTIVITIES.UomActivity;
import com.example.amit.kohinoor_applicationn.ACTIVITIES.UserActivity;
import com.example.amit.kohinoor_applicationn.ACTIVITIES.VendorActivity;
import com.example.amit.kohinoor_applicationn.R;
import com.example.amit.kohinoor_applicationn.USER_DATABASE.View_Activity;

public class FragmentTwo extends ListFragment implements AdapterView.OnItemClickListener {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        //View view = inflater.inflate(R.layout.fragment_fragment_two, container, false);
        //return view;
//perfoem action on button click

        final RelativeLayout mRelativeLayout = (RelativeLayout) inflater.inflate(R.layout.fragment_fragment_two,
                container, false);


        Button mButton = (Button) mRelativeLayout.findViewById(R.id.sendbutton);
        Button ubutton = (Button) mRelativeLayout.findViewById(R.id.userbutton);
        Button vbutton = (Button) mRelativeLayout.findViewById(R.id.vandorbutton);
        Button uombutton = (Button) mRelativeLayout.findViewById(R.id.uombutton);
        Button smbutton = (Button) mRelativeLayout.findViewById(R.id.smbutton);
        Button materialbutton = (Button) mRelativeLayout.findViewById(R.id.Materialbutton);
        Button sitebutton = (Button) mRelativeLayout.findViewById(R.id.Sitebutton);
        Button companybutton = (Button) mRelativeLayout.findViewById(R.id.Companybutton);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // here you set what you want to do when user clicks your button,
                Intent intent = new Intent(getActivity(), MachineryActivity.class);
                startActivity(intent);
            }
        });

        ubutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // here you set what you want to do when user clicks your button,
                Intent intent = new Intent(getActivity(), UserActivity.class);
                startActivity(intent);
            }
        });

        vbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // here you set what you want to do when user clicks your button,
                Intent intent = new Intent(getActivity(), VendorActivity.class);
                startActivity(intent);
            }
        });

        uombutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // here you set what you want to do when user clicks your button,
                Intent intent = new Intent(getActivity(), UomActivity.class);
                startActivity(intent);
            }
        });

        smbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // here you set what you want to do when user clicks your button,
                Intent intent = new Intent(getActivity(), SubMaterialActivity.class);
                startActivity(intent);
            }
        });

        materialbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // here you set what you want to do when user clicks your button,
                Intent intent = new Intent(getActivity(), MaterialActivity.class);
                startActivity(intent);
            }
        });

        sitebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // here you set what you want to do when user clicks your button,
                Intent intent = new Intent(getActivity(), SiteActivity.class);
                startActivity(intent);
            }
        });

        companybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // here you set what you want to do when user clicks your button,
                Intent intent = new Intent(getActivity(), CompanyActivity.class);
                startActivity(intent);
            }
        });


        // after you've done all your manipulation, return your layout to be shown
        return mRelativeLayout;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Masters, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent i = new Intent(getActivity().getBaseContext(),
                MachineryActivity.class);

        //PACK DATA
        i.putExtra("SENDER_KEY", "MyFragment");
        startActivity(i);


        //RESET WIDGETS

    }

    public interface OnFragmentInteractionListener {
    }


}

 /*extends ListFragment implements AdapterView.OnItemClickListener {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FragmentTwo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentTwo.
     */
// TODO: Rename and change types and number of parameters
    /*public static FragmentTwo newInstance(String param1, String param2) {
        FragmentTwo fragment = new FragmentTwo();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

            ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                    R.array.Masters, android.R.layout.simple_list_item_1);
            setListAdapter(adapter);
            getListView().setOnItemClickListener(this);
        }

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

  final RelativeLayout mRelativeLayout = (RelativeLayout) inflater.inflate(R.layout.fragment_fragment_two,
                container, false);

        Button mButton = (Button) mRelativeLayout.findViewById(R.id.sendbutton);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // here you set what you want to do when user clicks your button,
                Intent intent = new Intent(getActivity(), MachineryActivity.class);
                startActivity(intent);
            }
        });

        // after you've done all your manipulation, return your layout to be shown
        return mRelativeLayout;
    }

    }



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
   /* public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
    }

}*/
