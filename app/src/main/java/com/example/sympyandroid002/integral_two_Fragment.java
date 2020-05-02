package com.example.sympyandroid002;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;
import com.example.sympyandroid002.databinding.FragmentIntegralTwoBinding;

import java.util.Objects;

import io.noties.markwon.Markwon;
import io.noties.markwon.ext.latex.JLatexMathPlugin;
import io.noties.markwon.inlineparser.MarkwonInlineParserPlugin;


/**
 * A simple {@link Fragment} subclass.
 */
public class integral_two_Fragment extends Fragment {
    private FragmentIntegralTwoBinding binding;
    public integral_two_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentIntegralTwoBinding.inflate(getLayoutInflater());
        return binding.getRoot();
//        return inflater.inflate(R.layout.fragment_integral_two_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Markwon markwon = Markwon.builder(Objects.requireNonNull(getContext()))
                // required plugin to support inline parsing
                .usePlugin(MarkwonInlineParserPlugin.create())
                .usePlugin(JLatexMathPlugin.create(binding.integralTwoTextViewDisplay.getTextSize(), new JLatexMathPlugin.BuilderConfigure() {
                    @Override
                    public void configureBuilder(@NonNull JLatexMathPlugin.Builder builder) {
                        // ENABLE inlines
                        builder.inlinesEnabled(true);
                    }
                }))
                .build();
        initPython();
        final Python python = Python.getInstance();
        String show = "输入函数即可\n无需积分、微分符号\n不定积分变量一定要放在左边那栏\n含不定积分计算较慢";
        binding.integralTwoTextViewDisplay.setTextSize(TypedValue.COMPLEX_UNIT_PX,46);
        binding.integralTwoTextViewDisplay.setText(show);
//        binding.integralTwoTextViewDisplay.setTextSize(36);
        binding.integralTwoButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_integral_two_Fragment_to_homeFragment);
            }
        });
        binding.integralTwoButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.integralTwoTextViewDisplay.setTextSize(36);
                String latex = String.valueOf(binding.integralTwoEditText.getText());
                String symbol_1 = String.valueOf(binding.integralTwoEditText11.getText());
                String up_1= String.valueOf(binding.integralTwoEditText12.getText());
                String low_1= String.valueOf(binding.integralTwoEditText13.getText());
                String symbol_2 = String.valueOf(binding.integralTwoEditText21.getText());
                String up_2= String.valueOf(binding.integralTwoEditText22.getText());
                String low_2= String.valueOf(binding.integralTwoEditText23.getText());
                String answer = String.valueOf(python.getModule("High_number").callAttr("high_two_integral",latex,symbol_1,low_1,up_1,symbol_2,low_2,up_2));
                answer="$$\n"+answer+"\n$$";
                markwon.setMarkdown(binding.integralTwoTextViewDisplay,answer);
            }
        });
    }

    private void initPython(){
        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(Objects.requireNonNull(getContext())));
        }
    }
}
