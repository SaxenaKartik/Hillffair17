package com.nith.appteam.hillffair17.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nith.appteam.hillffair17.R;
import com.nith.appteam.hillffair17.Adapters.CoreTeamAdapter;
import com.nith.appteam.hillffair17.Models.CoreTeamItem;

import java.util.ArrayList;

public class CoreTeamActivity extends AppCompatActivity {
    RecyclerView recycler_view;
    CoreTeamAdapter core_team_adapter;
    ArrayList<CoreTeamItem> array_list;
    Toolbar core_team_toolbar;
    private static final String BASE_URL="https://api-hillfair-2k16.herokuapp.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_core_team);
        recycler_view=(RecyclerView)findViewById(R.id.core_team_list);
        array_list=new ArrayList<>();
        array_list.add(new CoreTeamItem("Ajay k. Sharma","Director",BASE_URL+"photos/director.jpg"));
        array_list.add(new CoreTeamItem("Dr. Raman Parti","Dean Student Welfare","https://s3-ap-southeast-1.amazonaws.com/nimbus2k16/nimbusteam/raman_parti.png"));
        array_list.add(new CoreTeamItem("Dr. Surender Soni","Faculty Coordinator","https://s3-ap-southeast-1.amazonaws.com/nimbus2k16/nimbusteam/surender_soni.png"));
        array_list.add(new CoreTeamItem("Deepak Kumar Jain","Hillffair Secretary",BASE_URL+"photos/deepak_kumar_jain.jpg"));
        array_list.add(new CoreTeamItem("Rishabh Bhandari","Clubs Secretary",BASE_URL+"photos/rishabh_bhandari.jpg"));
        array_list.add(new CoreTeamItem("Sourabh Thakur","Jt. Secretary(Dramatics)",BASE_URL+"photos/sourabh_thakur.jpg"));
        array_list.add(new CoreTeamItem("Mukul Chandel","Creative Head(Pixonoids)",BASE_URL+"photos/mukul_chandel.jpg"));
        array_list.add(new CoreTeamItem("Avantika Sharma","Graphic Head(Pixonoids)",BASE_URL+"photos/avantika_sharma.jpg"));
        array_list.add(new CoreTeamItem("Bhanu Pratap Singh","Jt. Secretary(Music Club)",BASE_URL+"photos/bhanu_pratap.jpg"));
        array_list.add(new CoreTeamItem("Medha Agrawal","Jt. Secretary(PR Club)",BASE_URL+"photos/medha_agrawal.jpg"));
        array_list.add(new CoreTeamItem("Aprajit Pandit","Jt. Secretary(Dance Club)",BASE_URL+"photos/aprajit_pandit.jpg"));
        array_list.add(new CoreTeamItem("Aanchal Negi","Jt. Secretary(Fashion Prade)",BASE_URL+"photos/aanchal_negi.jpg"));
        array_list.add(new CoreTeamItem("Aditya Verma","Jt. Secretary(Discipline committee)",BASE_URL+"photos/aditya_verma.jpg"));
        array_list.add(new CoreTeamItem("Shikhar Shrivastava","Jt. Secretary(Organization)",BASE_URL+"photos/shikhar_shrivastava.jpg"));
        array_list.add(new CoreTeamItem("Naveen Banyal","Jt. Secretary(Technical Committee)",BASE_URL+"photos/naveen_banyal.jpg"));
        core_team_adapter=new CoreTeamAdapter(array_list,CoreTeamActivity.this);
        recycler_view.setAdapter(core_team_adapter);
        LinearLayoutManager liner_layout_manager=new LinearLayoutManager(this);
        liner_layout_manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler_view.setLayoutManager(liner_layout_manager);

        core_team_toolbar=(Toolbar)findViewById(R.id.core_team_toolbar);
        core_team_toolbar.setTitle("Core Team");
        setSupportActionBar(core_team_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void openBottomSheet(View v) {
        View view = getLayoutInflater().inflate(R.layout.bottom_sheet, null);
        TextView txtBackup = (TextView) view.findViewById(R.id.txt_backup);
        TextView txtDetail = (TextView) view.findViewById(R.id.txt_detail);
        TextView txtOpen = (TextView) view.findViewById(R.id.txt_open);
        final TextView txtUninstall = (TextView) view.findViewById(R.id.txt_uninstall);
        final Dialog mBottomSheetDialog = new Dialog(CoreTeamActivity.this, R.style.MaterialDialogSheet);
        mBottomSheetDialog.setContentView(view);
        mBottomSheetDialog.setCancelable(true);
        mBottomSheetDialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        mBottomSheetDialog.getWindow().setGravity(Gravity.BOTTOM);
        mBottomSheetDialog.show();
        txtBackup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(ContributorsActivity.this, "Clicked Backup", Toast.LENGTH_SHORT).show();
                Intent i1 = new Intent(CoreTeamActivity.this, BattleDayActivity.class);
                startActivity(i1);
                finish();
                mBottomSheetDialog.dismiss();
            }
        });
        txtDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CoreTeamActivity.this, "Clicked Detail", Toast.LENGTH_SHORT).show();
                mBottomSheetDialog.dismiss();
            }
        });
        txtOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(ContributorsActivity.this, "Clicked Open", Toast.LENGTH_SHORT).show();
                Intent i3 = new Intent(CoreTeamActivity.this, EventActivity.class);
                startActivity(i3);
                finish();
                mBottomSheetDialog.dismiss();
            }
        });
        txtUninstall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(ContributorsActivity.this, "Clicked Uninstall", Toast.LENGTH_SHORT).show();
                Intent i4 = new Intent(CoreTeamActivity.this, SponsorActivity.class);
                startActivity(i4);
                finish();
                mBottomSheetDialog.dismiss();
            }
        });
    }
}
