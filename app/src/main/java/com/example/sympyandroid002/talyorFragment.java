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
import com.example.sympyandroid002.databinding.FragmentTalyorBinding;

import java.util.Objects;

import io.noties.markwon.Markwon;
import io.noties.markwon.ext.latex.JLatexMathPlugin;
import io.noties.markwon.inlineparser.MarkwonInlineParserPlugin;


/**
 * A simple {@link Fragment} subclass.
 */
public class talyorFragment extends Fragment {
    private FragmentTalyorBinding binding;
    public talyorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTalyorBinding.inflate(getLayoutInflater());
        return binding.getRoot();
//        return inflater.inflate(R.layout.fragment_talyor, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Markwon markwon = Markwon.builder(Objects.requireNonNull(getContext()))
                // required plugin to support inline parsing
                .usePlugin(MarkwonInlineParserPlugin.create())
                .usePlugin(JLatexMathPlugin.create(binding.tylorTextViewDisplay.getTextSize(), new JLatexMathPlugin.BuilderConfigure() {
                    @Override
                    public void configureBuilder(@NonNull JLatexMathPlugin.Builder builder) {
                        // ENABLE inlines
                        builder.inlinesEnabled(true);
                    }
                }))
                .build();
        initPython();
        binding.tylorButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_talyorFragment_to_homeFragment);
            }
        });
        final Python python =Python.getInstance();
        String show = "输入函数即可\n请保证变量是x";
        binding.tylorTextViewDisplay.setText(show);
        binding.tylorButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String latex = String.valueOf(binding.tylorEditText1.getText());
                String start = String.valueOf(binding.tylorEditText2.getText());
                String order = String.valueOf(binding.tylorEditText3.getText());
                String answer  = String.valueOf(python.getModule("High_number").callAttr("high_tylor",latex,Integer.parseInt(start),Integer.parseInt(order)));
                answer="$$\n"+answer+"\n$$";
                markwon.setMarkdown(binding.tylorTextViewDisplay,answer);
            }
        });


    }
    private void initPython(){
        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(Objects.requireNonNull(getContext())));
        }
    }
}
