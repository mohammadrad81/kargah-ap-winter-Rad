package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * controller class for my calculator
 * @author Mohammad Heydari Rad
 * @since 6/19/2021
 * @version 1.0
 */
public class Controller {

    private Operators operator = null;
    private float first;
    private float second;
    private float ans;

    @FXML
    private TextField enterTextField;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button buttonMulti;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button buttonDiv;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Button buttonPlus;

    @FXML
    private Button button0;

    @FXML
    private Button buttonDot;

    @FXML
    private Button buttonResult;

    @FXML
    private Button buttonMinus;

    @FXML
    private Button buttonSin;

    @FXML
    private Button buttonCos;

    @FXML
    private Button buttonTan;

    @FXML
    private Button buttonPow;

    @FXML
    private Button buttonClear;

    /**
     * when a button is pressed
     * this handler method does the correct answer
     * @param event is the event of the pressed button
     */
    @FXML
    void buttonActionHandler(ActionEvent event) {

        if(enterTextField.getText().equals("Infinity") ||
            enterTextField.getText().equals("! error !") ||
            enterTextField.getText().equals("NaN")){
            enterTextField.clear();
        }

        Button button = (Button) event.getSource();
        if(event.getSource() == button0 ||
                button == button1 ||
                button == button2 ||
                button == button3 ||
                button == button4 ||
                button == button5 ||
                button == button6 ||
                button == button7 ||
                button == button8 ||
                button == button9 ||
                button == buttonDot){
            enterTextField.setText(enterTextField.getText() + button.getText());
        }
        else if(button == buttonSin ||
                button == buttonCos ||
                button == buttonTan){
                try {
                    first = Float.parseFloat(enterTextField.getText());
                }catch (Exception e){
                    enterTextField.setText("! error !");
                    return;
                }



                if(button == buttonSin){
                    operator = Operators.sin;
                } else if(button == buttonCos){
                    operator = Operators.cos;
                } else if(button == buttonTan){
                    operator = Operators.tan;
                }

                try {
                    ans = calculate(operator , first);
                }catch (Exception e){
                    enterTextField.setText("! error !");

                }
        }

        else if(button == buttonPlus ||
                button == buttonMinus ||
                button == buttonMulti ||
                button == buttonDiv ||
                button == buttonPow){

                first = Float.parseFloat(enterTextField.getText());

                enterTextField.clear();

                if(button == buttonPlus){
                    operator = Operators.addition;
                } else if(button == buttonMinus){
                    operator = Operators.subtraction;
                } else if(button == buttonMulti){
                    operator = Operators.multiplication;
                }else if(button == buttonDiv){
                    operator = Operators.divination;
                }else if(button == buttonPow){
                    operator = Operators.pow;
                }
        }

        else if(button == buttonClear){
            clear();
        }

        else if(button == buttonResult){
            if(operator == Operators.sin ||
                operator == Operators.cos||
                operator == Operators.tan){
                enterTextField.setText(Float.toString(ans));
            }
            else {
                second = Float.parseFloat(enterTextField.getText());

                try {
                    ans = calculate(first , operator , second);
                    enterTextField.setText(Float.toString(ans));
                }catch (Exception e){
                    enterTextField.setText("! error !");
                }
            }
        }


    }

    /**
     * calculates the unary calculations ( sin , cos , tan , pow )
     * @param operator is the unary operator
     * @param number is the calculating number
     * @return the result of the calculation
     */
    private float calculate(Operators operator , float number){
        float ans = 0;
        if(operator == Operators.sin){
            ans = (float) Math.sin(number);
        } else if(operator == Operators.cos){
            ans = (float) Math.cos(number);
        } else if(operator == Operators.tan){
            ans = (float) Math.tan(number);
        }
        return ans;
    }

    /**
     * calculates the binary calculations
     * @param number1 is the first number
     * @param operator is the operator
     * @param number2 is the second number
     * @return the result of the calculation
     */
    private float calculate(float number1 , Operators operator , float number2){
        float ans = 0;
        if(operator == Operators.addition){
            ans = number1 + number2;
        }
        else if(operator == Operators.subtraction){
            ans = number1 - number2;
        }
        else if(operator == Operators.multiplication){
            ans = number1 * number2;
        }
        else if(operator == Operators.divination){
            if(Double.compare(number2 , 0) == 0){
                throw new RuntimeException();
            }
            else {
                ans = number1 / number2;
            }
        }
        else if(operator == Operators.pow){
            ans = (float) Math.pow(number1 , number2);
        }
        return ans;
    }

    /**
     * clears the calculator
     */
    private void clear(){
        ans = 0;
        operator = null;
        first = 0;
        second = 0;
        enterTextField.clear();
    }

}
