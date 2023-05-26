/*

    GROUP HOMEWORK - ELEVATOR GAME

    Description: This is a small elevator game designed for CENG201 Object Oriented
    Programming assignment. Every aspect of this app is self-explanatory. Buttons
    and text fields are placed carefully to improve user experience. Have fun!

    Contributors:
    Arif Fil, 20050111037
    Zehra İnöz, 20050111019
    Beyhan Kandemir, 20050111051
    Arda Şafak Parlar, 20050111043
    Sertac İnce, 20050111003

    Contacts:

    Github: https://github.com/EpicCMoment/ElevatorGame
    E-mail: you_shall_not_pass@middleearth.com
    Twitter: @baldGandalf

    NOTE: IF YOU HAVE EPILEPSY DISORDER, DO NOT TOUCH THE REMOVE ADS BUTTON

 */


package com.elevatorgame.elevatorgame;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;


public class ElevatorGame extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage mainWindow) {

        /*
        For every couple function;
        1-) Set the image
        2-) Set the actual object

        Correct usage:
            setElevatorImage();
            setElevator();

        Incorrect usage:
            setElevator();
            setElevatorImage();
         */

        // don't change the order of the function calls below
        // if you are NOT SURE about what are you doing


        // below functions are self-explanatory

        setGifImage();

        setBuildingImage();

        setElevatorImage();
        setElevator();

        setElevatorControlsLabel();

        setInformationMessageLabel();
        setInformationMessageArea();

        setElevatorUpButtonImage();
        setElevatorUpButton();

        setLastPersonInTheElevatorLabel();
        setLastPersonInTheElevatorText();

        setLastPersonTargetLabel();

        setCurrentFloorText();

        setLastPersonTargetText();

        setElevatorStatusLabel();


        setElevatorDownButtonImage();
        setElevatorDownButton();

        setNewPersonFieldsLabel();
        setNewPersonNameText();
        setNewPersonTargetText();
        setAddNewPersonButton();

        setDarkModeButton();
        setHaveFunButton();

        setMainBackground();

        setMainLayout();
        setMainWindow(mainWindow);



        // run the actual GUI
        mainWindow.show();


    }

    Elevator elevator;  // elevator ADT
    ImageView elevatorImage;    // image of the elevator in the app

    Button darkModeButton;  // button to switch between dark and light mode
    Button haveFunButton;   // ύ񥦘󥤖ҵ⼍񘄻ӛƺږ䕕쇑찘輥뇸肟泦勺ꠥ
    Pane mainBackground = new Pane();   // container of the all GUI elements
    Label informationMessageLabel;  // label to specify information message area
    TextArea informationMessageArea;    // area to print information messages
    ImageView buildingImage;    // image of the building in the app
    ImageView gifImage;

    Label lastPersonInTheElevatorLabel; // label to specify the textfield of the
                                        // person available to get out
    TextField lastPersonInTheElevatorText;  // area to print person to get out

    Label elevatorStatusLabel;  // label to specify section of the elevator status
    Label lastPersonTargetLabel;    // target floor of the person who is going
                                    // to get out
    TextField currentFloorText; // textfield of the where elevator at
    TextField lastPersonTargetText; // textfield of the person available to
                                    // get out

    Label elevatorControlsLabel;    // label of the elevator buttons
    ImageView elevatorUpButtonImage;    // image of the up elevator button
    Button elevatorUpButton;    // up button of the elevator
    ImageView elevatorDownButtonImage;  // image of the down elevator button
    Button elevatorDownButton;  // down button of the elevator
    TextField newPersonNameText;    // name of the new person to add
    TextField newPersonTargetText;  // target of the new person to add
    Button addNewPersonButton;  // button to add new person
    Scene mainLayout;   // outer layout
    Label newPersonFieldsLabel; // label that specifies new person infos

    double betweenFloorSpace = 128; // space between floors in the building

    boolean isDark = false; // is theme dark?

    int buttonWidth = 100;

    public void setDarkModeButton() {
        darkModeButton = new Button("Change Theme");
        darkModeButton.setMaxWidth(buttonWidth);
        darkModeButton.setMinWidth(buttonWidth);
        darkModeButton.setLayoutX(470);
        darkModeButton.setLayoutY(20);

        // if theme is dark, make it light
        // if it is light do vice versa
        darkModeButton.setOnAction(e -> {
            if (!isDark) {
                // fill the background with a custom color
                mainBackground.setBackground(new Background(new BackgroundFill(new Color(0.176, 0.012, 0.231, 1), new CornerRadii(0), new Insets(0))));

                // make all the texts white
                lastPersonTargetLabel.setTextFill(Color.WHITE);
                elevatorControlsLabel.setTextFill(Color.WHITE);
                lastPersonInTheElevatorLabel.setTextFill(Color.WHITE);
                informationMessageLabel.setTextFill(Color.WHITE);
                newPersonFieldsLabel.setTextFill(Color.WHITE);
                elevatorStatusLabel.setTextFill(Color.WHITE);

                isDark = true;
            } else {
                // fill the background with white color
                mainBackground.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), new Insets(0))));

                // make all the texts black
                lastPersonTargetLabel.setTextFill(Color.BLACK);
                elevatorControlsLabel.setTextFill(Color.BLACK);
                lastPersonInTheElevatorLabel.setTextFill(Color.BLACK);
                informationMessageLabel.setTextFill(Color.BLACK);
                newPersonFieldsLabel.setTextFill(Color.BLACK);
                elevatorStatusLabel.setTextFill(Color.BLACK);

                isDark = false;
            }
        });

    }

    // a strange function with no meaning
    public void setHaveFunButton() {
        haveFunButton = new Button("Remove Ads");
        haveFunButton.setMaxWidth(buttonWidth);
        haveFunButton.setMinWidth(buttonWidth);
        haveFunButton.setLayoutX(darkModeButton.getLayoutX() + 120);
        haveFunButton.setLayoutY(darkModeButton.getLayoutY());

        haveFunButton.setOnAction(e -> {
            Timeline tm = new Timeline(new KeyFrame(Duration.millis(25), ep -> {darkModeButton.fire(); gifImage.setVisible(true);}));
            informationMessageArea.setText("YOU SHALL NOT REMOVE THE ADS \nYOU SHALL NOT REMOVE THE ADS \nYOU SHALL NOT REMOVE THE ADS \nYOU SHALL NOT REMOVE THE ADS");

            tm.setCycleCount(350);
            tm.play();
            tm.setOnFinished(r -> {informationMessageArea.setText(""); gifImage.setVisible(false);});
        });
    }


    public void setElevator() {
        elevator = new Elevator(4, 0, 5);
    }

    private void setInformationMessageLabel() {
        informationMessageLabel = new Label("Information messages");
        informationMessageLabel.setLayoutX(480);
        informationMessageLabel.setLayoutY(680);
    }
    public void setInformationMessageArea() {
        informationMessageArea = new TextArea();
        informationMessageArea.setEditable(false);  // make it untouchable
        informationMessageArea.setLayoutX(informationMessageLabel.getLayoutX());
        informationMessageArea.setLayoutY(informationMessageLabel.getLayoutY() + 20);
        informationMessageArea.setMaxWidth(220);
        informationMessageArea.setMinWidth(220);
        informationMessageArea.setMaxHeight(100);
        informationMessageArea.setMinHeight(100);
    }

    public void setGifImage() {
        String imagePath = "https://raw.githubusercontent.com/EpicCMoment/ElevatorGame/main/src/main/java/com/elevatorgame/elevatorgame/giphy.gif";
        gifImage = new ImageView(imagePath);
        gifImage.setFitWidth(280);
        gifImage.setFitHeight(140);
        gifImage.setLayoutX(450);
        gifImage.setLayoutY(530);
        gifImage.setVisible(false);
    }

    public void setBuildingImage() {

        // fetch image from web
        String imagePath = "https://raw.githubusercontent.com/EpicCMoment/ElevatorGame/main/src/main/java/com/elevatorgame/elevatorgame/building.png";
        buildingImage = new ImageView(imagePath);
        buildingImage.setFitWidth(400);
        buildingImage.setFitHeight(800);
        buildingImage.setLayoutX(20);
    }

    public void setElevatorImage() {

        // fetch image from web
        String imagePath = "https://raw.githubusercontent.com/EpicCMoment/ElevatorGame/main/src/main/java/com/elevatorgame/elevatorgame/elevator.png";
        elevatorImage = new ImageView(imagePath);
        elevatorImage.setFitHeight(100);
        elevatorImage.setFitWidth(100);
        elevatorImage.setLayoutX(173);
        elevatorImage.setLayoutY(700);
    }

    public void setElevatorStatusLabel() {
     elevatorStatusLabel = new Label("Elevator Status");
     elevatorStatusLabel.setMaxWidth(100);
     elevatorStatusLabel.setMinWidth(100);
     elevatorStatusLabel.setLayoutX(elevatorControlsLabel.getLayoutX() + 150);
     elevatorStatusLabel.setLayoutY(elevatorControlsLabel.getLayoutY());

    }

    public void setLastPersonInTheElevatorLabel() {
        lastPersonInTheElevatorLabel = new Label("Last Person: ");
        lastPersonInTheElevatorLabel.setMaxWidth(200);
        lastPersonInTheElevatorLabel.setMinWidth(200);
        lastPersonInTheElevatorLabel.setLayoutX(elevatorUpButton.getLayoutX() + 90);
        lastPersonInTheElevatorLabel.setLayoutY(elevatorUpButton.getLayoutY() + 10);

    }

    public void setLastPersonInTheElevatorText() {
        lastPersonInTheElevatorText = new TextField();
        lastPersonInTheElevatorText.setAlignment(Pos.CENTER);
        lastPersonInTheElevatorText.setMaxWidth(90);
        lastPersonInTheElevatorText.setMinWidth(90);
        lastPersonInTheElevatorText.setEditable(false);
        lastPersonInTheElevatorText.setLayoutX(lastPersonInTheElevatorLabel.getLayoutX() + 70 );
        lastPersonInTheElevatorText.setLayoutY(lastPersonInTheElevatorLabel.getLayoutY());
    }

    public void setLastPersonTargetLabel() {
        lastPersonTargetLabel = new Label("Target floor: ");
        lastPersonTargetLabel.setMaxWidth(200);
        lastPersonTargetLabel.setMinWidth(200);
        lastPersonTargetLabel.setLayoutX(lastPersonInTheElevatorLabel.getLayoutX());
        lastPersonTargetLabel.setLayoutY(lastPersonInTheElevatorLabel.getLayoutY() + 35);
    }

    public void setLastPersonTargetText() {
        lastPersonTargetText = new TextField();
        lastPersonTargetText.setAlignment(Pos.CENTER);
        lastPersonTargetText.setMaxWidth(90);
        lastPersonTargetText.setMinWidth(90);
        lastPersonTargetText.setEditable(false);
        lastPersonTargetText.setLayoutX(lastPersonTargetLabel.getLayoutX() + 70);
        lastPersonTargetText.setLayoutY(lastPersonTargetLabel.getLayoutY());
    }


    public void setCurrentFloorText() {
        currentFloorText = new TextField();
        currentFloorText.setAlignment(Pos.CENTER);
        currentFloorText.setText("0");
        currentFloorText.setMaxWidth(25);
        currentFloorText.setMinWidth(25);
        currentFloorText.setMaxHeight(25);
        currentFloorText.setMinHeight(25);
        currentFloorText.setEditable(false);
        currentFloorText.setLayoutX(elevatorImage.getLayoutX() + 38);
        currentFloorText.setLayoutY(elevatorImage.getLayoutY() + 5);
    }

    public void setElevatorControlsLabel() {
        elevatorControlsLabel = new Label("Elevator Controls");
        elevatorControlsLabel.setMaxWidth(100);
        elevatorControlsLabel.setMinWidth(100);
        elevatorControlsLabel.setLayoutX(460);
        elevatorControlsLabel.setLayoutY(400);
    }

    public void setElevatorUpButtonImage() {

        // fetch image from web
        String imagePath = "https://raw.githubusercontent.com/EpicCMoment/ElevatorGame/main/src/main/java/com/elevatorgame/elevatorgame/up_arrow.png";
        elevatorUpButtonImage = new ImageView(imagePath);
        elevatorUpButtonImage.setFitWidth(30);
        elevatorUpButtonImage.setFitHeight(30);
    }

    public void setElevatorUpButton() {
        elevatorUpButton = new Button();
        elevatorUpButton.setGraphic(elevatorUpButtonImage);
        elevatorUpButton.setLayoutX(elevatorControlsLabel.getLayoutX() + 20);
        elevatorUpButton.setLayoutY(elevatorControlsLabel.getLayoutY() + 20);


        // on click
        elevatorUpButton.setOnAction((e) -> {


            // if elevator is not at the top floor
            if (elevator.getCurrentFloor() != elevator.getMaxFloor()) {

                // move the elevator image to the upper floor
                elevatorImage.setLayoutY(elevatorImage.getLayoutY() - betweenFloorSpace);
                // move the floor counter
                currentFloorText.setLayoutY(currentFloorText.getLayoutY() - betweenFloorSpace);


                String lastPersonName;
                boolean isEmpty = elevator.getPeople().isEmpty();

                // if elevator is not empty
                if (!isEmpty) {

                    // get the name of the person who is going to get out possibly
                    ElevatorPerson ep = (ElevatorPerson)elevator.getPeople().peek();
                    lastPersonName = ep.getPerson().getName();

                } else { // if elevator is empty
                    lastPersonName = "";
                }

                // get the number of the person in the elevator before and after
                // moving to the next floor
                int beforeCapacity = elevator.getPeople().getSize();
                elevator.goToFloor(elevator.getCurrentFloor() + 1);
                int afterCapacity = elevator.getPeople().getSize();

                // check emptiness again for future use
                isEmpty = elevator.getPeople().isEmpty();

                if (afterCapacity != beforeCapacity) { // if someone got out
                    informationMessageArea.appendText(lastPersonName + " is out.\n");
                    if (isEmpty) { // if elevator is empty now
                        informationMessageArea.appendText("Elevator is empty.\n");
                    }
                }


                // if elevator is not empty
                // set the next available person to get out
                if (!isEmpty) {
                    ElevatorPerson lastPerson = (ElevatorPerson)(elevator.getPeople().peek());
                    lastPersonInTheElevatorText.setText(lastPerson.getPerson().getName());
                    lastPersonTargetText.setText(Integer.toString(lastPerson.getTarget()));
                } else {

                    lastPersonInTheElevatorText.setText("");
                    lastPersonTargetText.setText("");
                }

                // update the current floor field on the application
                currentFloorText.setText(Integer.toString(elevator.getCurrentFloor()));
            }

        });
    }

    public void setElevatorDownButtonImage() {
        String imagePath = "https://raw.githubusercontent.com/EpicCMoment/ElevatorGame/main/src/main/java/com/elevatorgame/elevatorgame/down_arrow.png";
        elevatorDownButtonImage = new ImageView(imagePath);
        elevatorDownButtonImage.setFitWidth(30);
        elevatorDownButtonImage.setFitHeight(30);
    }

    public void setElevatorDownButton() {
        elevatorDownButton = new Button();
        elevatorDownButton.setGraphic(elevatorDownButtonImage);
        elevatorDownButton.setLayoutX(elevatorUpButton.getLayoutX());
        elevatorDownButton.setLayoutY(elevatorUpButton.getLayoutY() + 45);

        // if elevator is not at the bottom floor
        elevatorDownButton.setOnAction((e) -> {
            if (elevator.getCurrentFloor() != elevator.getMinFloor()) {

                // move the elevator image to the bottom floor
                elevatorImage.setLayoutY(elevatorImage.getLayoutY() + betweenFloorSpace);
                currentFloorText.setLayoutY(currentFloorText.getLayoutY() + betweenFloorSpace);


                String lastPersonName;
                boolean isEmpty = elevator.getPeople().isEmpty();

                // if elevator is not empty
                if (!isEmpty) { // get the name of the person who is possibly going to get out

                    ElevatorPerson ep = (ElevatorPerson)elevator.getPeople().peek();
                    lastPersonName = ep.getPerson().getName();
                } else { // if elevator is empty no one is going to get out next time
                    lastPersonName = "";
                }

                // get the number of the person in the elevator before and after
                // moving to the next floor
                int beforeCapacity = elevator.getPeople().getSize();
                elevator.goToFloor(elevator.getCurrentFloor() - 1);
                int afterCapacity = elevator.getPeople().getSize();

                // check emptiness again for future use
                isEmpty = elevator.getPeople().isEmpty();


                // if someone has gotten out
                if (afterCapacity != beforeCapacity) {
                    informationMessageArea.appendText(lastPersonName + " is out..\n");
                    if (isEmpty) {
                        informationMessageArea.appendText("Elevator is empty.\n");
                    }
                }

                // if elevator is not empty
                // set the next available person to get out
                if (!isEmpty) {
                    ElevatorPerson lastPerson = (ElevatorPerson)(elevator.getPeople().peek());
                    lastPersonInTheElevatorText.setText(lastPerson.getPerson().getName());
                    lastPersonTargetText.setText(Integer.toString(lastPerson.getTarget()));
                } else {
                    lastPersonInTheElevatorText.setText("");
                    lastPersonTargetText.setText("");
                }

                currentFloorText.setText(Integer.toString(elevator.getCurrentFloor()));


            }

        });
    }

    private void setNewPersonFieldsLabel() {
        newPersonFieldsLabel = new Label("Add a new person");
        newPersonFieldsLabel.setLayoutX(510);
        newPersonFieldsLabel.setLayoutY(120);
    }

    public void setNewPersonNameText() {
        newPersonNameText = new TextField();
        newPersonNameText.setPromptText("Name");
        newPersonNameText.setLayoutX(newPersonFieldsLabel.getLayoutX());
        newPersonNameText.setLayoutY(newPersonFieldsLabel.getLayoutY() + 20);
    }

    public void setNewPersonTargetText() {
        newPersonTargetText = new TextField();
        newPersonTargetText.setPromptText("Target Floor");
        newPersonTargetText.setLayoutX(newPersonNameText.getLayoutX());
        newPersonTargetText.setLayoutY(newPersonNameText.getLayoutY() + 30);
    }

    public void setAddNewPersonButton() {
        addNewPersonButton = new Button("Add");
        addNewPersonButton.setLayoutX(newPersonNameText.getLayoutX());
        addNewPersonButton.setLayoutY(newPersonTargetText.getLayoutY() + 30);
        addNewPersonButton.setPrefWidth(147);


        addNewPersonButton.setOnAction((e) -> {

            // get the name of the new person
            String personName = newPersonNameText.getText();

            // target floor of the new person
            int personTarget;

            // check for the correctness of the target floor prompt
            try {
                Integer.parseInt(newPersonTargetText.getText());

            } catch (Exception ep) { // if target floor is invalid
                informationMessageArea.appendText("Invalid target floor!\n");
                newPersonNameText.setText("");
                newPersonTargetText.setText("");
                return;
            }

            // extract the target floor
            personTarget = Integer.parseInt(newPersonTargetText.getText());

            // if target floor is out of bounds
            if (personTarget > elevator.getMaxFloor() || personTarget < elevator.getMinFloor()) {
                informationMessageArea.appendText("Invalid target floor!\n");
                newPersonNameText.setText("");
                newPersonTargetText.setText("");
                return;
            }

            // create a new person
            Person temp = new Person(personName);

            // if elevator is empty add person into the elevator in
            // a different manner
            if (elevator.getPeople().isEmpty()) {
                elevator.enter(temp, personTarget);
                lastPersonInTheElevatorText.setText(personName);
                lastPersonTargetText.setText(Integer.toString(personTarget));
                informationMessageArea.appendText(personName + " has entered the elevator.\n");

            } else { // if elevator has some people in it

                // if elevator is full
                if (elevator.getPeople().getSize() == elevator.getCapacity()) {
                    informationMessageArea.appendText("Elevator is full.\n");

                } else { // add the new person to the elevator
                    lastPersonInTheElevatorText.setText(personName);
                    elevator.enter(temp, personTarget);
                    lastPersonTargetText.setText(Integer.toString(personTarget));
                    informationMessageArea.appendText(personName + " has entered the elevator.\n");
                }

            }

            newPersonNameText.setText("");
            newPersonTargetText.setText("");

        });
    }

    public void setMainBackground() {
        // make dark mode

        ObservableList<Node> backgroundElements = mainBackground.getChildren();

        backgroundElements.add(buildingImage);
        backgroundElements.add(lastPersonInTheElevatorLabel);
        backgroundElements.add(lastPersonInTheElevatorText);
        backgroundElements.add(lastPersonTargetLabel);
        backgroundElements.add(lastPersonTargetText);
        backgroundElements.add(currentFloorText);
        backgroundElements.add(elevatorUpButton);
        backgroundElements.add(elevatorDownButton);
        backgroundElements.add(elevatorImage);
        backgroundElements.add(newPersonNameText);
        backgroundElements.add(newPersonTargetText);
        backgroundElements.add(addNewPersonButton);
        backgroundElements.add(informationMessageArea);
        backgroundElements.add(newPersonFieldsLabel);
        backgroundElements.add(informationMessageLabel);
        backgroundElements.add(elevatorControlsLabel);
        backgroundElements.add(elevatorStatusLabel);
        backgroundElements.add(darkModeButton);
        backgroundElements.add(haveFunButton);
        backgroundElements.add(gifImage);
    }

    public void setMainLayout() {
        mainLayout = new Scene(mainBackground, 750, 850);


    }

    public void setMainWindow(Stage mainWindow) {

        String iconURL = "https://raw.githubusercontent.com/EpicCMoment/ElevatorGame/main/src/main/java/com/elevatorgame/elevatorgame/icon.png";

        mainWindow.setResizable(false);
        mainWindow.getIcons().add(new Image(iconURL));

        mainWindow.setScene(mainLayout);
    }
}
