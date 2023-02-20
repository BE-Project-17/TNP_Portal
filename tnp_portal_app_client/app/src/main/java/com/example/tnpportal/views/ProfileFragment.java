package com.example.tnpportal.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.tnpportal.R;
import com.example.tnpportal.databinding.FragmentProfileBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentProfileBinding binding;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init(){
        binding.profileDetails.firstName.setText("Prasad");
        binding.profileDetails.lastName.setText("Khalkar");
        binding.collegeDetails.detailsTitle.setText(R.string.college_details);
        binding.personalDetails.detailsTitle.setText(R.string.personal_details);
        binding.educationDetails.detailsTitle.setText(R.string.education_details);
        binding.amcatDetails.detailsTitle.setText(R.string.amcat_details);
        binding.experienceDetails.detailsTitle.setText(R.string.experience_details);

        binding.collegeDetails.detailsTable.addView(getRow("Name: ","Prasad Khalkar"));
        binding.collegeDetails.detailsTable.addView(getRow("Roll No: ","43138"));
        binding.collegeDetails.detailsTable.addView(getRow("Seat No: ","B190058605"));
        binding.collegeDetails.detailsTable.addView(getRow("Branch: ","IT"));

        binding.personalDetails.detailsTable.addView(getRow("Email: ","aniketkhalkar791@gmail.com"));
        binding.personalDetails.detailsTable.addView(getRow("Phone No: ","8080177497"));
        binding.personalDetails.detailsTable.addView(getRow("Gender: ","Male"));

        binding.educationDetails.detailsTable.addView(getRow("SSC: ","91.2%"));
        binding.educationDetails.detailsTable.addView(getRow("HSC: ","78.6%"));
        binding.educationDetails.detailsTable.addView(getRow("Diploma: ","N/A"));
        binding.educationDetails.detailsTable.addView(getRow("CGPA: ","9.69"));

        binding.amcatDetails.detailsTable.addView(getRow("Quantitative Score: ","95.2%"));
        binding.amcatDetails.detailsTable.addView(getRow("Logical Reasoning Score: ","91.2%"));
        binding.amcatDetails.detailsTable.addView(getRow("English Prof Score: ","95.4%"));
        binding.amcatDetails.detailsTable.addView(getRow("AutomataPro Score: ","91.2%"));
        binding.amcatDetails.detailsTable.addView(getRow("Computer Science Score: ","99.5%"));

        binding.experienceDetails.detailsTable.addView(getRow("Internships: ","2"));
        binding.experienceDetails.detailsTable.addView(getRow("Project: ","5"));
        binding.experienceDetails.detailsTable.addView(getRow("Backlogs: ","0"));

        binding.collegeDetails.detailsTitle.setOnClickListener(view -> {
            if(binding.collegeDetails.detailsTable.getVisibility() == View.VISIBLE){
                binding.collegeDetails.detailsTable.setVisibility(View.GONE);
            }else{
                binding.collegeDetails.detailsTable.setVisibility(View.VISIBLE);
            }
        });

        binding.personalDetails.detailsTitle.setOnClickListener(view -> {
            if(binding.personalDetails.detailsTable.getVisibility() == View.VISIBLE){
                binding.personalDetails.detailsTable.setVisibility(View.GONE);
            }else{
                binding.personalDetails.detailsTable.setVisibility(View.VISIBLE);
            }
        });

        binding.educationDetails.detailsTitle.setOnClickListener(view -> {
            if(binding.educationDetails.detailsTable.getVisibility() == View.VISIBLE){
                binding.educationDetails.detailsTable.setVisibility(View.GONE);
            }else{
                binding.educationDetails.detailsTable.setVisibility(View.VISIBLE);
            }
        });

        binding.amcatDetails.detailsTitle.setOnClickListener(view -> {
            if(binding.amcatDetails.detailsTable.getVisibility() == View.VISIBLE){
                binding.amcatDetails.detailsTable.setVisibility(View.GONE);
            }else{
                binding.amcatDetails.detailsTable.setVisibility(View.VISIBLE);
            }
        });

        binding.experienceDetails.detailsTitle.setOnClickListener(view -> {
            if(binding.experienceDetails.detailsTable.getVisibility() == View.VISIBLE){
                binding.experienceDetails.detailsTable.setVisibility(View.GONE);
            }else{
                binding.experienceDetails.detailsTable.setVisibility(View.VISIBLE);
            }
        });

    }

    private TableRow getRow(String title, String value){
        final TableRow tableRow = new TableRow(getActivity());
        tableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,TableLayout.LayoutParams.WRAP_CONTENT));
        tableRow.addView(getTextView(title,R.color.dark_grey,false,18));
        tableRow.addView(getTextView(value,R.color.blue,true,14));
        return tableRow;
    }

    private TextView getTextView(String text,int color, boolean toRight,int size){
        TextView textView = new TextView(getActivity());
        textView.setText(text);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, toRight?1f:4f);
        lp.setMargins(0,5,0,5);
        lp.gravity = toRight ? Gravity.END : Gravity.START;
        textView.setLayoutParams(lp);
        textView.setTextColor(this.getResources().getColor(color));
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,size);
        return textView;
    }
}