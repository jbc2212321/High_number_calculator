package com.example.sympyandroid002;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;
import com.example.sympyandroid002.databinding.FragmentIntegralOneBinding;

import java.util.Objects;

import io.noties.markwon.Markwon;
import io.noties.markwon.ext.latex.JLatexMathPlugin;
import io.noties.markwon.inlineparser.MarkwonInlineParserPlugin;


/**
 * A simple {@link Fragment} subclass.
 */
public class integral_one_Fragment extends Fragment {
    private FragmentIntegralOneBinding binding;
    public integral_one_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentIntegralOneBinding.inflate(getLayoutInflater());
        return binding.getRoot();
//        return inflater.inflate(R.layout.fragment_integral_one_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Markwon markwon = Markwon.builder(Objects.requireNonNull(getContext()))
                // required plugin to support inline parsing
                .usePlugin(MarkwonInlineParserPlugin.create())
                .usePlugin(JLatexMathPlugin.create(binding.integralOneTextViewDisplay.getTextSize(), new JLatexMathPlugin.BuilderConfigure() {
                    @Override
                    public void configureBuilder(@NonNull JLatexMathPlugin.Builder builder) {
                        // ENABLE inlines
                        builder.inlinesEnabled(true);
                    }
                }))
                .build();
        initPython();
        final Python python = Python.getInstance();
        String show = "输入函数即可\n无需积分、微分符号";
        binding.integralOneTextViewDisplay.setText(show);
        binding.integralOneButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_integral_one_Fragment_to_homeFragment);
            }
        });
        binding.integralOneButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String latex = String.valueOf(binding.integralOneEditText1.getText());
                String symbol = String.valueOf(binding.integralOneEditText2.getText());
                String up= String.valueOf(binding.integralOneEditText3.getText());
                String low= String.valueOf(binding.integralOneEditText4.getText());
                String answer = String.valueOf(python.getModule("High_number").callAttr("high_one_integral",latex,symbol,low,up));
                answer="$$\n"+answer+"\n$$";
                markwon.setMarkdown(binding.integralOneTextViewDisplay,answer);
            }
        });
    }

    private void initPython(){
        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(Objects.requireNonNull(getContext())));
        }
    }
}
