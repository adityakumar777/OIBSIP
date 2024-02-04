package com.fusionx.myapplication;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.fusionx.myapplication.databinding.ActivityCalculationBinding;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class CalculationActivity extends AppCompatActivity {

    String[] area_unit_list;
    ActivityCalculationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCalculationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Intent intent = getIntent();
        String cardView = intent.getStringExtra("card_name");

        CardView output_card = findViewById(R.id.cardView_area_output);
            binding.outlinedTextFieldAreaUnit
                    .setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {
                        hideKeyboard(v);
                    }
                }
            });

        if ("card_area".equals(cardView)) {
             area_unit_list = new String[]{"Acre", "Hactare", "SquareMeter", "SquareFoot", "SquareInch", "SquareKilometer", "SquareYard"};

            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, area_unit_list);

            binding.autoCompleteTextViewFrom.setAdapter(adapter);
            binding.autoCompleteTextViewTo.setAdapter(adapter);
            adapter.notifyDataSetChanged();

            binding.buttonConvertArea.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        String fromUnit = binding.autoCompleteTextViewFrom.getText().toString();
                        String toUnit = binding.autoCompleteTextViewTo.getText().toString();

                        double enteredUnits = Double.parseDouble(binding.areaUnits.getText().toString());

                        AreaConverter.Unit fromUnit1 = AreaConverter.Unit.fromString(fromUnit);
                        AreaConverter.Unit toUnit1 = AreaConverter.Unit.fromString(toUnit);

                        AreaConverter converter = new AreaConverter(fromUnit1, toUnit1);
                        double result = converter.convert(enteredUnits);


                        output_card.setVisibility(View.VISIBLE);
                        binding.textViewAreaOutput.setText(String.valueOf(result) + " " + toUnit);
                    } catch (NumberFormatException e) {
                        binding.areaUnits.setError("Please enter some value!");
                        binding.areaUnits.requestFocus();
                    } catch (IllegalArgumentException e) {
                        Toast.makeText(getBaseContext(), "Select option from dropdown first!", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(getBaseContext(), "Error in conversion!", Toast.LENGTH_LONG).show();
                    }
                }
            });

        } else if (cardView.equals("card_speed")) {
            area_unit_list = new String[]{"MeterPerSecond", "FootPerSecond", "Knot", "KilometerPerHour", "MilesPerHour"};

            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, area_unit_list);

            binding.autoCompleteTextViewFrom.setAdapter(adapter);
            binding.autoCompleteTextViewTo.setAdapter(adapter);
            adapter.notifyDataSetChanged();

            binding.buttonConvertArea.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        String fromUnit = binding.autoCompleteTextViewFrom.getText().toString();
                        String toUnit = binding.autoCompleteTextViewTo.getText().toString();

                        double enteredUnits = Double.parseDouble(binding.areaUnits.getText().toString());

                        SpeedConverter.Unit fromUnit1 = SpeedConverter.Unit.fromString(fromUnit);
                        SpeedConverter.Unit toUnit1 = SpeedConverter.Unit.fromString(toUnit);

                        SpeedConverter converter = new SpeedConverter(fromUnit1, toUnit1);
                        double result = converter.convert(enteredUnits);


                        output_card.setVisibility(View.VISIBLE);
                        binding.textViewAreaOutput.setText(String.valueOf(result) + " " + toUnit);
                    } catch (NumberFormatException e) {
                        binding.areaUnits.setError("Please enter some value!");
                        binding.areaUnits.requestFocus();
                    } catch (IllegalArgumentException e) {
                        Toast.makeText(getBaseContext(), "Select option from dropdown first!", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(getBaseContext(), "Error in conversion!", Toast.LENGTH_LONG).show();
                    }
                }
            });


        } else if (cardView.equals("card_length")) {
            area_unit_list = new String[]{"Inch", "Centimeter", "Meter", "Mile", "Kilometer", "Foot", "Yard"};
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, area_unit_list);

            binding.autoCompleteTextViewFrom.setAdapter(adapter);
            binding.autoCompleteTextViewTo.setAdapter(adapter);
            adapter.notifyDataSetChanged();

            binding.buttonConvertArea.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        String fromUnit = binding.autoCompleteTextViewFrom.getText().toString();
                        String toUnit = binding.autoCompleteTextViewTo.getText().toString();

                        double enteredUnits = Double.parseDouble(binding.areaUnits.getText().toString());

                        LengthConverter.Unit fromUnit1 = LengthConverter.Unit.fromString(fromUnit);
                        LengthConverter.Unit toUnit1 = LengthConverter.Unit.fromString(toUnit);

                        LengthConverter converter = new LengthConverter(fromUnit1, toUnit1);
                        double result = converter.convert(enteredUnits);

                        output_card.setVisibility(View.VISIBLE);
                        binding.textViewAreaOutput.setText(String.valueOf(result) + " " + toUnit);
                    } catch (NumberFormatException e) {
                        binding.areaUnits.setError("Please enter some value!");
                        binding.areaUnits.requestFocus();
                    } catch (IllegalArgumentException e) {
                        Toast.makeText(getBaseContext(), "Select option from dropdown first!", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(getBaseContext(), "Error in conversion!", Toast.LENGTH_LONG).show();
                    }
                }
            });



        } else if (cardView.equals("card_temperature")) {
            area_unit_list = new String[]{"Celsius", "Fahrenheit", "Kelvin", "Rankine", "Reaumur"};
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, area_unit_list);

            binding.autoCompleteTextViewFrom.setAdapter(adapter);
            binding.autoCompleteTextViewTo.setAdapter(adapter);
            adapter.notifyDataSetChanged();

            binding.buttonConvertArea.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        String fromUnit = binding.autoCompleteTextViewFrom.getText().toString();
                        String toUnit = binding.autoCompleteTextViewTo.getText().toString();

                        double enteredUnits = Double.parseDouble(binding.areaUnits.getText().toString());

                        TemperatureConverter.Unit fromUnit1 = TemperatureConverter.Unit.fromString(fromUnit);
                        TemperatureConverter.Unit toUnit1 = TemperatureConverter.Unit.fromString(toUnit);

                        TemperatureConverter converter = new TemperatureConverter(fromUnit1, toUnit1);
                        double result = converter.convert(enteredUnits);


                        output_card.setVisibility(View.VISIBLE);
                        binding.textViewAreaOutput.setText(String.valueOf(result) + " " + toUnit);
                    } catch (NumberFormatException e) {
                        binding.areaUnits.setError("Please enter some value!");
                        binding.areaUnits.requestFocus();
                    } catch (IllegalArgumentException e) {
                        Toast.makeText(getBaseContext(), "Select option from dropdown first!", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(getBaseContext(), "Error in conversion!", Toast.LENGTH_LONG).show();
                    }
                }
            });

        } else if (cardView.equals("card_frequency")) {
            area_unit_list = new String[]{"Hertz", "KiloHertz", "MegaHertz", "GigaHertz"};
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, area_unit_list);

            binding.autoCompleteTextViewFrom.setAdapter(adapter);
            binding.autoCompleteTextViewTo.setAdapter(adapter);
            adapter.notifyDataSetChanged();

            binding.buttonConvertArea.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        String fromUnit = binding.autoCompleteTextViewFrom.getText().toString();
                        String toUnit = binding.autoCompleteTextViewTo.getText().toString();

                        double enteredUnits = Double.parseDouble(binding.areaUnits.getText().toString());

                        FrequencyConverter.Unit fromUnit1 = FrequencyConverter.Unit.fromString(fromUnit);
                        FrequencyConverter.Unit toUnit1 = FrequencyConverter.Unit.fromString(toUnit);

                        FrequencyConverter converter = new FrequencyConverter(fromUnit1, toUnit1);
                        double result = converter.convert(enteredUnits);


                        output_card.setVisibility(View.VISIBLE);
                        binding.textViewAreaOutput.setText(String.valueOf(result) + " " + toUnit);
                    } catch (NumberFormatException e) {
                        binding.areaUnits.setError("Please enter some value!");
                        binding.areaUnits.requestFocus();
                    } catch (IllegalArgumentException e) {
                        Toast.makeText(getBaseContext(), "Select option from dropdown first!", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(getBaseContext(), "Error in conversion!", Toast.LENGTH_LONG).show();
                    }
                }
            });
        } else if (cardView.equals("card_mass")) {
            area_unit_list = new String[]{"Tonne", "Kilogram", "Gram", "Milligram", "Pound", "Ounce"};
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, area_unit_list);

            binding.autoCompleteTextViewFrom.setAdapter(adapter);
            binding.autoCompleteTextViewTo.setAdapter(adapter);
            adapter.notifyDataSetChanged();

            binding.buttonConvertArea.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        String fromUnit = binding.autoCompleteTextViewFrom.getText().toString();
                        String toUnit = binding.autoCompleteTextViewTo.getText().toString();

                        double enteredUnits = Double.parseDouble(binding.areaUnits.getText().toString());

                        MassConverter.Unit fromUnit1 = MassConverter.Unit.fromString(fromUnit);
                        MassConverter.Unit toUnit1 = MassConverter.Unit.fromString(toUnit);

                        MassConverter converter = new MassConverter(fromUnit1, toUnit1);
                        double result = converter.convert(enteredUnits);



                        output_card.setVisibility(View.VISIBLE);
                        binding.textViewAreaOutput.setText(String.valueOf(result) + " " + toUnit);
                    } catch (NumberFormatException e) {
                        binding.areaUnits.setError("Please enter some value!");
                        binding.areaUnits.requestFocus();
                    } catch (IllegalArgumentException e) {
                        Toast.makeText(getBaseContext(), "Select option from dropdown first!", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(getBaseContext(), "Error in conversion!", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }


    }
    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(CalculationActivity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}