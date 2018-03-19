package com.kbnt.qam.calculatorview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kbnt.qam.calculatorview.util.SequenceBuilder;
import com.kbnt.qam.calculatorview.util.SequenceCalculator;

public class CalculatorView extends RelativeLayout {

    private TextView inputTextView;
    private TextView resultTextView;

    private SequenceBuilder builder;
    private SequenceCalculator calculator;

    public CalculatorView(Context context) {
        this(context, null);
    }

    public CalculatorView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CalculatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public CalculatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.layout_calculator, this);
        createSequenceBuilder();
        createSequenceCalculator();
        initWidgetViews();
        setWidgetActions();
    }


    private void initWidgetViews() {
        inputTextView = findViewById(R.id.inputTextView);
        resultTextView = findViewById(R.id.resultTextView);
    }

    private void createSequenceBuilder() {
        builder = new SequenceBuilder();
    }

    private void createSequenceCalculator() {
        calculator = new SequenceCalculator();
    }

    private void setWidgetActions() {
        setNumericButtonActions();
        setNotNumericButtonActions();
        setResultTextViewAction();
    }

    private void setNumericButtonActions() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputTextView.setText(appendNumber(((Button) view).getText()));
            }
        };
        findViewById(R.id.buttonOne).setOnClickListener(listener);
        findViewById(R.id.buttonTwo).setOnClickListener(listener);
        findViewById(R.id.buttonThree).setOnClickListener(listener);
        findViewById(R.id.buttonFour).setOnClickListener(listener);
        findViewById(R.id.buttonFive).setOnClickListener(listener);
        findViewById(R.id.buttonSix).setOnClickListener(listener);
        findViewById(R.id.buttonSeven).setOnClickListener(listener);
        findViewById(R.id.buttonEight).setOnClickListener(listener);
        findViewById(R.id.buttonNine).setOnClickListener(listener);
        findViewById(R.id.buttonZero).setOnClickListener(listener);
    }

    private String appendNumber(CharSequence text) {
        return builder.appendNumber(text.toString());
    }

    private void setNotNumericButtonActions() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputTextView.setText(appendSign(((Button) view).getText()));
                resultTextView.setText(getSequenceResult());
            }
        };
        findViewById(R.id.buttonPlus).setOnClickListener(listener);
        findViewById(R.id.buttonMinus).setOnClickListener(listener);
        findViewById(R.id.buttonMultiply).setOnClickListener(listener);
        findViewById(R.id.buttonDivide).setOnClickListener(listener);
        findViewById(R.id.buttonEqual).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTextView.setText(getSequenceResult());
            }
        });
        findViewById(R.id.buttonClear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputTextView.setText(builder.clear());
                resultTextView.setText(null);
            }
        });
    }

    private String appendSign(CharSequence text) {
        return builder.appendAction(text.toString());
    }

    private String getSequenceResult() {
        return String.valueOf(calculator.calculate(builder.getSequence()));
    }

    private void setResultTextViewAction() {
        resultTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.clear();
                inputTextView.setText(builder.appendNumber(resultTextView.getText().toString()));
                resultTextView.setText(null);
            }
        });
    }
}
