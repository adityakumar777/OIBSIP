package com.fusion.fusioncalculator;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.window.OnBackInvokedDispatcher;

import com.fusion.fusioncalculator.databinding.ActivityMainBinding;
import com.saadahmedsoft.popupdialog.PopupDialog;
import com.saadahmedsoft.popupdialog.Styles;
import com.saadahmedsoft.popupdialog.listener.OnDialogButtonClickListener;
import com.shashank.sony.fancytoastlib.FancyToast;


public class MainActivity extends AppCompatActivity {

    private Calculator mCalculator;
    private double number_one, number_two;
    private String operation_string;
    private static int MAX_CHARACTERS = 10;

    private enum operator {
        ADD, SUB, MUL, DIV, MOD, ROOT, POW, NULL
    }
    
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Show the custom dialog
                showExitConfirmationDialog();
            }
        };

        // Add the callback to the OnBackPressedDispatcher
        getOnBackPressedDispatcher().addCallback(this, onBackPressedCallback);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mCalculator = new Calculator();
        operation_string = operator.NULL.name();

        if (savedInstanceState != null) {
            binding.inputValue1.setText(savedInstanceState.getString("First_number", ""));
            binding.inputValue2.setText(savedInstanceState.getString("Second_number", ""));
            binding.inputOperation.setText(savedInstanceState.getString("Operation", ""));
            binding.textViewResult.setText(savedInstanceState.getString("Final_result", ""));
            binding.completeOperation.setText(savedInstanceState.getString("Complete_operation", ""));
            operation_string = savedInstanceState.getString("Operation_string", operator.NULL.name());
            number_one = savedInstanceState.getDouble("Number_one", 0);
            number_two = savedInstanceState.getDouble("Number_two", 0);
        }

    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("First_number", binding.inputValue1.getText().toString());
        outState.putString("Operation", binding.inputOperation.getText().toString());
        outState.putString("Second_number", binding.inputValue2.getText().toString());
        outState.putString("Final_result", binding.textViewResult.getText().toString());
        outState.putString("Complete_operation", binding.completeOperation.getText().toString());
        outState.putString("Operation_string", operation_string);
        outState.putDouble("Number_one", number_one);
        outState.putDouble("Number_two", number_two);
    }

    private void selectTextViewToAppend(String number) {
        if (operation_string.equals(operator.NULL.name())) {
            if (binding.inputValue1.getText().toString().contains(".")) {
                MAX_CHARACTERS++;
            }
            if (binding.inputValue1.getText().length() < MAX_CHARACTERS) {
                binding.inputValue1.append(number);
                MAX_CHARACTERS = 10;
            } else {
                MAX_CHARACTERS = 10;
                FancyToast.makeText(this,"More than 10 digits are not allowed",FancyToast.LENGTH_LONG,FancyToast.WARNING,true).show();
            }
        } else {
            if (binding.inputValue1.getText().toString().contains(".")) {
                MAX_CHARACTERS++;
            }
            if (binding.inputValue2.getText().length() < MAX_CHARACTERS) {
                binding.inputValue2.append(number);
                MAX_CHARACTERS = 10;
            } else {
                MAX_CHARACTERS = 10;
                FancyToast.makeText(this,"More than 10 digits are not allowed",FancyToast.LENGTH_LONG,FancyToast.WARNING,true).show();
            }

        }
    }

    public void onNumClick(View view) {
        if (!binding.textViewResult.getText().toString().equals("")) {
            onClearClick(view);
        }

        int id = view.getId();
        if (id == R.id.button_one) {
            selectTextViewToAppend("1");
        } else if (id == R.id.button_two) {
            selectTextViewToAppend("2");
        } else if (id == R.id.button_three) {
            selectTextViewToAppend("3");
        } else if (id == R.id.button_four) {
            selectTextViewToAppend("4");
        } else if (id == R.id.button_five) {
            selectTextViewToAppend("5");
        } else if (id == R.id.button_six) {
            selectTextViewToAppend("6");
        } else if (id == R.id.button_seven) {
            selectTextViewToAppend("7");
        } else if (id == R.id.button_eight) {
            selectTextViewToAppend("8");
        } else if (id == R.id.button_nine) {
            selectTextViewToAppend("9");
        } else if (id == R.id.button_zero) {
            selectTextViewToAppend("0");
        } else if (id == R.id.button_dot) {
            if (operation_string.equals(operator.NULL.name())) {
                if (binding.inputValue1.getText().toString().contains(".")) {
                    Toast.makeText(this, "Cannot have more than one decimal point in a number", Toast.LENGTH_LONG).show();
                } else {
                    binding.inputValue1.append(".");
                }
            } else {
                if (binding.inputValue2.getText().toString().contains(".")) {
                    Toast.makeText(this, "Cannot have more than one decimal point in a number", Toast.LENGTH_LONG).show();
                } else {
                    binding.inputValue2.append(".");
                }
            }
        }
    }

    public void onOperatorClick(View view) {
        if (!binding.inputValue1.getText().toString().equals("")) {

            int id = view.getId();
            if (id == R.id.button_plus) {
                operation_string = operator.ADD.name();
                binding.inputOperation.setText("+");
            } else if (id == R.id.button_minus) {
                operation_string = operator.SUB.name();
                binding.inputOperation.setText("-");
            } else if (id == R.id.button_multiply) {
                operation_string = operator.MUL.name();
                binding.inputOperation.setText("x");
            } else if (id == R.id.button_divide) {
                operation_string = operator.DIV.name();
                binding.inputOperation.setText("/");
            } else if (id == R.id.button_mod) {
                operation_string = operator.MOD.name();
                binding.inputOperation.setText("%");
            } else if (id == R.id.button_pow) {
                operation_string = operator.POW.name();
                binding.inputOperation.setText("^");
            } else if (id == R.id.button_root) {
                operation_string = operator.ROOT.name();
                binding.inputOperation.setText("√");
            } else {
                operation_string = operator.NULL.name();
            }

        }
        else if (view.getId() == R.id.button_root) {
            binding.inputValue1.setText("1");
            operation_string = operator.ROOT.name();
            binding.inputOperation.setText("√");
        }
        else {
            Toast.makeText(this, "Enter first number before operation", Toast.LENGTH_LONG).show();
        }
    }

    public void onEqualsClick(View view) {

        if (binding.inputValue1.getText().toString().equals("") || binding.inputOperation.getText().toString().equals("") || binding.inputValue2.getText().toString().equals("")) {
            Toast.makeText(this, "Enter the numbers and the operation", Toast.LENGTH_LONG).show();
        } else {
            number_one = Double.parseDouble(binding.inputValue1.getText().toString());
            number_two = Double.parseDouble(binding.inputValue2.getText().toString());
            String operation;

            switch (operator.valueOf(operation_string)) {
                case ADD:
                    binding.textViewResult.setText(String.valueOf(mCalculator.addition(number_one, number_two)));
                    operation = binding.inputValue1.getText().toString() + getString(R.string.button_plus) + binding.inputValue2.getText().toString();
                    break;
                case SUB:
                    binding.textViewResult.setText(String.valueOf(mCalculator.subtraction(number_one, number_two)));
                    operation = binding.inputValue1.getText().toString() + getString(R.string.button_minus) + binding.inputValue2.getText().toString();
                    break;
                case MUL:
                    binding.textViewResult.setText(String.valueOf(mCalculator.multiplication(number_one, number_two)));
                    operation = binding.inputValue1.getText().toString() + getString(R.string.button_mul) + binding.inputValue2.getText().toString();
                    break;
                case DIV:
                    try {
                        binding.textViewResult.setText(String.valueOf(mCalculator.division(number_one, number_two)));
                        operation = binding.inputValue1.getText().toString() + getString(R.string.button_div) + binding.inputValue2.getText().toString();
                    } catch (IllegalArgumentException e) {
                        Toast.makeText(this, getString(R.string.error), Toast.LENGTH_LONG).show();
                        operation = "";
                        clearAll();
                    }
                    break;
                case MOD:
                    binding.textViewResult.setText(String.valueOf(mCalculator.modulus(number_one, number_two)));
                    operation = binding.inputValue1.getText().toString() + getString(R.string.button_mod) + binding.inputValue2.getText().toString();
                    break;
                case ROOT:
                    binding.textViewResult.setText(String.valueOf(mCalculator.squareRoot(number_one, number_two)));
                    operation = binding.inputValue1.getText().toString() + getString(R.string.button_root) + binding.inputValue2.getText().toString();
                    break;
                case POW:
                    binding.textViewResult.setText(String.valueOf(mCalculator.power(number_one, number_two)));
                    operation = binding.inputValue1.getText().toString() + getString(R.string.button_pow) + binding.inputValue2.getText().toString();
                    break;
                case NULL:
                    binding.textViewResult.setText(getString(R.string.error));
                    operation = "";
                    break;
                default:
                    operation = "";
                    break;
            }
            binding.completeOperation.setText(operation);
            clearAll();
        }
    }

    public void onClearClick(View view) {
        clearAll();
        binding.textViewResult.setText("");
        binding.completeOperation.setText("");
    }

    public void clearAll() {
        binding.inputValue1.setText("");
        binding.inputOperation.setText("");
        binding.inputValue2.setText("");
        number_one = 0;
        number_two = 0;
        operation_string = operator.NULL.name();
    }


    public void onBackspaceClick(View view) {
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                clearAll();
                return false;
            }
        });
        if (!binding.inputValue2.getText().toString().equals("")) {
            backspaceImplementation(binding.inputValue2);
        } else {
            if (!binding.inputOperation.getText().toString().equals("")) {
                backspaceImplementation(binding.inputOperation);
            } else {
                if (!binding.inputValue1.getText().toString().equals("")) {
                    backspaceImplementation(binding.inputValue1);
                }
            }
        }
    }

    private void backspaceImplementation(TextView view) {
        String backspace = view.getText().toString();
        backspace = backspace.substring(0, backspace.length() - 1);
        view.setText(backspace);
    }


    private void showExitConfirmationDialog() {

        PopupDialog.getInstance(this)
                .setStyle(Styles.IOS)
                .setHeading("Exit")
                .setDescription("Are you sure you want to exit?")
                .setCancelable(false)
                .showDialog(new OnDialogButtonClickListener() {
                    @Override
                    public void onPositiveClicked(Dialog dialog) {
                        finish();
                    }

                    @Override
                    public void onNegativeClicked(Dialog dialog) {
                        dialog.dismiss();
                    }
                });
    }

}
