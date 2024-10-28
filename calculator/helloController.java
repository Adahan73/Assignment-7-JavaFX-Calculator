package org.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HelloController {
    public Button clear;
    calculator calculator = new calculator();
    private boolean isOperatorPressed;

    {
        isOperatorPressed = false;
    }

    private boolean isResultDisplayed;
    {
        isResultDisplayed = false;
    }
    @FXML
    private TextField txt_result;

    @FXML
    void Number(ActionEvent event) {
        Button button = (Button) event.getSource();
        String number = button.getText();
        if(isResultDisplayed)
        {
            txt_result.setText("");// Очищаем поле если уже есть результат
            isResultDisplayed = false;
        }
        if(isOperatorPressed)
        {
            txt_result.setText("");// Очищаем поле после оператора для использования 2
            isOperatorPressed = false;
        }
        String oldText = txt_result.getText();
        String newText = oldText + number;
        txt_result.setText(newText);
    }

    @FXML
    void Operation(ActionEvent event) {
        Button button = (Button) event.getSource();
        String operation = button.getText();
        txt_result.getText();
        calculator.setOperand1(Double.parseDouble(txt_result.getText()));
        calculator.setOperator(operation.charAt(0));
        isOperatorPressed=true;
        isResultDisplayed=true;
    }

    @FXML
    void equals(ActionEvent ignoredEvent) {
        // Устанавливаем второй операнд и выполняем вычисление
        calculator.setOperand2(Double.parseDouble(txt_result.getText()));

        if (calculator.isError()) {
            txt_result.setText("ERROR");
        } else txt_result.setText(String.valueOf(calculator.getResult()));

        isResultDisplayed = true;  // Отображен результат, можно начать новый расчет
    }

    @FXML
    void point (ActionEvent event){
        Button button = (Button) event.getSource();
        String point = button.getText();
        String oldText = txt_result.getText();
        if (!oldText.contains(".")) { // Проверяем если точка уже или нет, если есть то не добавляем
            String newText = oldText + point;//если нет, то добавляем
            txt_result.setText(newText);
        }
    }
    @FXML
    void clear (ActionEvent ignoredEvent)
    {
        txt_result.setText("");
        isResultDisplayed=false;
        isOperatorPressed=false;

    }
}

