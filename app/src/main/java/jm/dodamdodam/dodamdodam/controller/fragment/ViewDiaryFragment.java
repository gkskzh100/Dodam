package jm.dodamdodam.dodamdodam.controller.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import jm.dodamdodam.dodamdodam.Global;
import jm.dodamdodam.dodamdodam.R;
import jm.dodamdodam.dodamdodam.data.DiaryModel;

/**
 * Created by IronFactory on 15. 11. 29..
 */
public class ViewDiaryFragment extends Fragment {

    private static final String TAG = "ViewDiaryFragment";

    private DiaryModel diary;

    private TextView feelView;
    private TextView contentView;
    private TextView dateView;

    public static ViewDiaryFragment newInstance(DiaryModel diary) {
        ViewDiaryFragment fragment = new ViewDiaryFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Global.DIARY, diary);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        diary = (DiaryModel) getArguments().getSerializable(Global.DIARY);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_view_diary, container, false);
        init(rootView);
        return rootView;
    }


    private void init(View rootView) {
        feelView = (TextView) rootView.findViewById(R.id.fragment_view_feel);
        contentView = (TextView) rootView.findViewById(R.id.fragment_view_content);
        dateView = (TextView) rootView.findViewById(R.id.fragment_view_date);

        setDiary();
    }


    private void setDiary() {
        setFeel(diary.getFeel());
        setDate();
        contentView.setText(diary.getContent());
    }


    private void setDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        Date currentTime = new Date(diary.getDate());
        String time = simpleDateFormat.format(currentTime);
        dateView.setText(time);
    }



    // TODO: 15. 11. 29. 기분
    private void setFeel(int feel) {
        switch (feel) {
            case Global.HAPPY:
                feelView.setText("행복");
                break;

            case Global.SCARY:
                feelView.setText("무서움");
                break;

            case Global.SHY:
                feelView.setText("부끄러움");
                break;

            case Global.ANGRY:
                feelView.setText("화남");
                break;

            case Global.SAD:
                feelView.setText("슬픔");
                break;
        }

    }
}