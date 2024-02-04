package com.fusionx.myapplication;

public class MassConverter {
    public enum Unit {
        Tonne,
        Kilogram,
        Gram,
        Milligram,
        Pound,
        Ounce;

        // Helper method to convert text to one of the above constants
        public static Unit fromString(String text) {
            if (text != null) {
                for (Unit unit : Unit.values()) {
                    if (text.equalsIgnoreCase(unit.toString())) {
                        return unit;
                    }
                }
            }

            throw new IllegalArgumentException("Cannot find a value for " + text);
        }
    }

    private final double multiplier;

    public MassConverter(Unit from, Unit to) {
        double constant = 1;

        switch (from) {
            case Tonne:
                if (to == Unit.Kilogram) {
                    constant = 1000;
                } else if (to == Unit.Gram) {
                    constant = 1e+6;
                } else if (to == Unit.Milligram) {
                    constant = 1e+9;
                } else if (to == Unit.Pound) {
                    constant = 2204.62;
                } else if (to == Unit.Ounce) {
                    constant = 35274;
                }
                break;
            case Kilogram:
                if (to == Unit.Tonne) {
                    constant = 0.001;
                } else if (to == Unit.Gram) {
                    constant = 1000;
                } else if (to == Unit.Milligram) {
                    constant = 1e+6;
                } else if (to == Unit.Pound) {
                    constant = 2.20462;
                } else if (to == Unit.Ounce) {
                    constant = 35.274;
                }
                break;
            case Gram:
                if (to == Unit.Tonne) {
                    constant = 1e-6;
                } else if (to == Unit.Kilogram) {
                    constant = 0.001;
                } else if (to == Unit.Milligram) {
                    constant = 1000;
                } else if (to == Unit.Pound) {
                    constant = 0.00220462;
                } else if (to == Unit.Ounce) {
                    constant = 0.035274;
                }
                break;
            case Milligram:
                if (to == Unit.Tonne) {
                    constant = 1e-9;
                } else if (to == Unit.Kilogram) {
                    constant = 1e-6;
                } else if (to == Unit.Gram) {
                    constant = 0.001;
                } else if (to == Unit.Pound) {
                    constant = 2.2046e-6;
                } else if (to == Unit.Ounce) {
                    constant = 3.5274e-5;
                }
                break;
            case Pound:
                if (to == Unit.Tonne) {
                    constant = 0.000453592;
                } else if (to == Unit.Kilogram) {
                    constant = 0.453592;
                } else if (to == Unit.Gram) {
                    constant = 453.592;
                } else if (to == Unit.Milligram) {
                    constant = 453592;
                } else if (to == Unit.Ounce) {
                    constant = 16;
                }
                break;
            case Ounce:
                if (to == Unit.Tonne) {
                    constant = 2.835e-5;
                } else if (to == Unit.Kilogram) {
                    constant = 0.0283495;
                } else if (to == Unit.Gram) {
                    constant = 28.3495;
                } else if (to == Unit.Milligram) {
                    constant = 28349.5;
                } else if (to == Unit.Pound) {
                    constant = 0.0625;
                }
                break;
        }

        multiplier = constant;
    }

    public double convert(double input) {
        return input * multiplier;
    }
}
