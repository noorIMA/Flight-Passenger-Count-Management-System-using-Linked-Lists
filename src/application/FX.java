
package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FX extends Application {

	public static void main(String[] args) throws FileNotFoundException {

		Application.launch(args);
	}

	Linked_ListF listF = new Linked_ListF();
	LinkedListP passenger = new LinkedListP();
	File outputFile = new File("flights.txt");
	File outputFile1 = new File("passenger.txt");

	@Override
	public void start(Stage stage) throws Exception {

		BorderPane bp = new BorderPane();
		VBox vb = new VBox();

		Label label1 = new Label(" Airline Ticket Reservation System   ");
		label1.setPrefWidth(230);
		label1.setTranslateY(90);
		label1.setTranslateX(585);
		label1.setStyle("-fx-background-color: pink; -fx-padding: 20px;");

		ImageView enterIm = new ImageView("https://img.icons8.com/cute-clipart/344/enter-2.png");
		enterIm.setFitWidth(30);
		enterIm.setFitHeight(30);
		Button enterB = new Button("Enter", enterIm);
		enterB.setTranslateX(600);
		enterB.setTranslateY(200);
		enterB.setPrefSize(200, 80);
		enterB.setStyle("-fx-border-color:pink");

		vb.getChildren().addAll(label1, enterB);
		vb.setSpacing(40);

		bp.setCenter(vb);

		enterB.setOnAction(e -> {
			try {
				list(stage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		Scene scene = new Scene(bp, 1500, 800);
		stage.setScene(scene);
		stage.show();
	}

	public void list(Stage stage) throws Exception {
		BorderPane bp = new BorderPane();
		VBox vb1 = new VBox();

		Label label1 = new Label("    List :)    ");
		label1.setPrefWidth(150);
		label1.setTranslateY(15);
		label1.setTranslateX(585);
		label1.setStyle("-fx-background-color: pink; -fx-padding: 20px;");

		Button read = new Button(" Read Data ");
		read.setTranslateX(550);
		read.setTranslateY(5);
		read.setPrefSize(230, 40);
		read.setStyle("-fx-border-color:pink");

		Button displayF = new Button(" Display Flight’s Information ");
		displayF.setTranslateX(550);
		displayF.setTranslateY(5);
		displayF.setPrefSize(230, 40);
		displayF.setStyle("-fx-border-color:pink");

		Button displayP = new Button(" Display Passengers Information ");
		displayP.setTranslateX(550);
		displayP.setTranslateY(5);
		displayP.setPrefSize(230, 40);
		displayP.setStyle("-fx-border-color:pink");

		Button AEF = new Button(" Add And Edit Flight ");
		AEF.setTranslateX(550);
		AEF.setTranslateY(5);
		AEF.setPrefSize(230, 40);
		AEF.setStyle("-fx-border-color:pink");

		Button reserve = new Button(" Reserve ");
		reserve.setTranslateX(550);
		reserve.setTranslateY(5);
		reserve.setPrefSize(230, 40);
		reserve.setStyle("-fx-border-color:pink");

		Button cancelR = new Button(" Cancel a Reservation  ");
		cancelR.setTranslateX(550);
		cancelR.setTranslateY(5);
		cancelR.setPrefSize(230, 40);
		cancelR.setStyle("-fx-border-color:pink");

		Button Check = new Button(" Check Ticket Is Reserved   ");
		Check.setTranslateX(550);
		Check.setTranslateY(5);
		Check.setPrefSize(230, 40);
		Check.setStyle("-fx-border-color:pink");

		Button search = new Button(" Search For A Passenger   ");
		search.setTranslateX(550);
		search.setTranslateY(5);
		search.setPrefSize(230, 40);
		search.setStyle("-fx-border-color:pink");

		Button exit = new Button(" Exit  ");
		exit.setTranslateX(550);
		exit.setTranslateY(5);
		exit.setPrefSize(230, 40);
		exit.setStyle("-fx-border-color:pink");

		vb1.getChildren().addAll(label1, read, displayF, displayP, AEF, reserve, cancelR, Check, search, exit);
		vb1.setSpacing(30);

		bp.setCenter(vb1);

		read.setOnAction(a -> {
			try {
				FileChooser(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		displayF.setOnAction(d -> {
			try {
				printFlughts(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		displayP.setOnAction(u -> {
			try {
				printPassenger(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		AEF.setOnAction(s -> {
			try {
				andEidtFlughts(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		reserve.setOnAction(p -> {
			try {
				reserveTicket(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		cancelR.setOnAction(m -> {
			try {
				CancelReserve(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		Check.setOnAction(m -> {
			try {
				check(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		search.setOnAction(m -> {
			try {
				searchPassenger(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		exit.setOnAction(m -> {
			try {
				start(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		Scene scene = new Scene(bp, 1500, 800);
		stage.setScene(scene);
		stage.setTitle(" * List * ");
		stage.show();

	}

	public void FileChooser(Stage stage) throws Exception {

		BorderPane bp = new BorderPane();
		VBox vb = new VBox();
		try {

			FileChooser fil_chooser = new FileChooser();
			Label label = new Label("                  No Files Selected");
			label.setPrefWidth(230);
			label.setTranslateY(90);
			label.setTranslateX(585);
			label.setStyle("-fx-background-color: pink; -fx-padding: 20px;");

			Button button1 = new Button(" Choose Flight");
			button1.setTranslateX(600);
			button1.setTranslateY(200);
			button1.setPrefSize(200, 80);
			button1.setStyle("-fx-border-color:pink");

			EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {

				public void handle(ActionEvent e) {
					File file1 = fil_chooser.showOpenDialog(stage);
					if (file1 != null) {

						label.setText(file1.getName() + "  Selected");
					}
					if (file1.exists()) {
						Scanner in = null;
						try {
							in = new Scanner(file1);
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						}
						int count = 0;
						while (in.hasNext()) {
							String line = in.nextLine();
							System.out.println(line);
							String[] splittedList = line.split(",");
							listF.add(count, new Flights(splittedList[0], splittedList[1], splittedList[2],
									splittedList[3], splittedList[4]));
							count++;
						//	System.out.println(listF);
						}
						in.close();
					} else
						System.out.println("Error: File Flights not found!!!");
				}
			};

			button1.setOnAction(event);

			Button button2 = new Button("Choose Passenger");
			button2.setTranslateX(600);
			button2.setTranslateY(200);
			button2.setPrefSize(200, 80);
			button2.setStyle("-fx-border-color:pink");

			EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {

				public void handle(ActionEvent e) {
					File file2 = fil_chooser.showOpenDialog(stage);
					if (file2 != null) {
						label.setText(file2.getName() + "  Selected");
					}
					if (file2.exists()) {
						Scanner in = null;
						try {
							in = new Scanner(file2);
						} catch (FileNotFoundException e1) {

							e1.printStackTrace();
						}
						int count = 0;
						while (in.hasNext()) {
							String line = in.nextLine();
							System.out.println(line);
							String[] splittedList = line.split(",");
							passenger.add(count, new Passenger(splittedList[0], splittedList[1], splittedList[2],
									splittedList[3], splittedList[4], splittedList[5]));
							count++;
						}

						in.close();
					} else
						System.out.println("Error: File Passenger not found!!!");
				}
			};

			button2.setOnAction(event1);

			ImageView backIm = new ImageView("https://img.icons8.com/fluency/344/circled-left-2.png");
			backIm.setFitWidth(30);
			backIm.setFitHeight(30);
			Button backB = new Button("Back", backIm);
			backB.setTranslateX(600);
			backB.setTranslateY(200);
			backB.setPrefSize(200, 80);
			backB.setStyle("-fx-border-color:pink");

			backB.setOnAction(b -> {
				try {
					list(stage);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});

			vb.getChildren().addAll(label, button1, button2, backB);
			vb.setSpacing(40);

			bp.setCenter(vb);
			Scene scene = new Scene(bp, 1500, 800);
			stage.setTitle("File Chooser");
			stage.setScene(scene);
			stage.show();
		}

		catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}

	public void printFlughts(Stage stage) throws Exception {
		GridPane gp = new GridPane();
		HBox hb = new HBox();

		Label label1 = new Label(" Print Flights Information : ");
		label1.setPrefWidth(200);
		label1.setTranslateY(40);
		label1.setTranslateX(10);
		label1.setStyle("-fx-background-color: pink; -fx-padding: 20px;");

		TextArea areaT = new TextArea();
		areaT.setText(" Flights Information ");
		areaT.setPrefColumnCount(15);
		areaT.setPrefRowCount(4);
		areaT.setWrapText(true);
		areaT.setPrefHeight(150);
		areaT.setPrefWidth(300);

		hb.setSpacing(20);
		hb.getChildren().addAll(label1, areaT);

		ImageView printIm = new ImageView("https://img.icons8.com/color/344/print.png");
		printIm.setFitWidth(30);
		printIm.setFitHeight(30);
		Button printB = new Button("Print", printIm);
		printB.setTranslateX(200);
		printB.setTranslateY(120);
		printB.setPrefSize(100, 80);
		printB.setStyle("-fx-border-color:pink");
		gp.add(printB, 1, 4);

		ImageView backIm = new ImageView("https://img.icons8.com/fluency/344/circled-left-2.png");
		backIm.setFitWidth(30);
		backIm.setFitHeight(30);
		Button backB = new Button("Back", backIm);
		backB.setTranslateX(200);
		backB.setTranslateY(120);
		backB.setPrefSize(100, 80);
		backB.setStyle("-fx-border-color:pink");
		gp.add(backB, 2, 4);

		printB.setOnAction(p -> {
		
			
			
			
			
			File file2 = new File("flights.txt");
			if (file2.exists()) {
				Scanner in;
				try {
					in = new Scanner(file2);
					while (in.hasNext()) {
						String line = in.nextLine();
						System.out.println(line);
						areaT.setText(line);}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
				
			}
		});

		backB.setOnAction(b -> {
			try {
				list(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		gp.add(hb, 0, 1);
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(15);

		Scene scene = new Scene(gp, 1500, 800);
		stage.setScene(scene);
		stage.setTitle(" * Print Flights Information  * ");
		stage.show();
	}

	public void printPassenger(Stage stage) throws Exception {
		GridPane gp = new GridPane();

		Label topLabel = new Label(" Print Passenger Information   ");
		topLabel.setFont(new Font(20));
		topLabel.setStyle("-fx-background-color: pink; -fx-padding: 20px;");
		gp.add(topLabel, 0, 0);
		gp.setAlignment(Pos.TOP_CENTER);

		Label numF = new Label(" Flight Number : ");
		numF.setFont(new Font(15));
		gp.add(numF, 0, 1);

		TextField numFTF = new TextField();
		numFTF.setPromptText(" Flight Number ");
		numFTF.setPrefColumnCount(20);
		gp.add(numFTF, 1, 1);

		TextArea areaTP = new TextArea();
		areaTP.setText(" Display  Passenger Information   ");
		areaTP.setPrefColumnCount(15);
		areaTP.setPrefRowCount(4);
		areaTP.setWrapText(true);
		areaTP.setPrefHeight(150);
		areaTP.setPrefWidth(300);
		areaTP.setDisable(true);
		gp.add(areaTP, 1, 2);

		ImageView printIm = new ImageView("https://img.icons8.com/color/344/print.png");
		printIm.setFitWidth(30);
		printIm.setFitHeight(30);
		Button printB = new Button("Print", printIm);
		printB.setTranslateX(200);
		printB.setTranslateY(120);
		printB.setPrefSize(100, 80);
		printB.setStyle("-fx-border-color:pink");
		gp.add(printB, 1, 4);

		ImageView backIm = new ImageView("https://img.icons8.com/fluency/344/circled-left-2.png");
		backIm.setFitWidth(30);
		backIm.setFitHeight(30);
		Button backB = new Button("Back", backIm);
		backB.setTranslateX(200);
		backB.setTranslateY(120);
		backB.setPrefSize(100, 80);
		backB.setStyle("-fx-border-color:pink");
		gp.add(backB, 2, 4);
		gp.setVgap(20);

		printB.setOnAction(p -> {
			
			LinkedListP passengers = listF.search(numFTF.getText());
			String passengersDetails = "";
			for (int s = 0; s < passengers.getSize(); s++) {

				passengersDetails = passengersDetails + passengers.get(s).toString() + "\n";
				System.out.println(passengersDetails);

			}

			areaTP.setText(passengersDetails);

		});

		backB.setOnAction(b -> {
			try {
				list(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		gp.setHgap(20);
		Scene scene = new Scene(gp, 1500, 800);
		stage.setScene(scene);
		stage.setTitle(" * Passenger Information  * ");
		stage.show();
	}

	public void andEidtFlughts(Stage stage) throws Exception {

		GridPane gp = new GridPane();

		Label topLabel = new Label(" Add And Eidt Flight ");
		topLabel.setFont(new Font(20));
		topLabel.setStyle("-fx-background-color: pink; -fx-padding: 20px;");
		gp.add(topLabel, 0, 0);
		gp.setAlignment(Pos.TOP_CENTER);

		Label num = new Label(" Flight Number : ");
		num.setFont(new Font(15));
		gp.add(num, 0, 1);

		Label name = new Label(" Airline Name : ");
		name.setFont(new Font(15));
		gp.add(name, 0, 2);

		Label source = new Label(" Source : ");
		source.setFont(new Font(15));
		gp.add(source, 0, 3);

		Label destination = new Label(" Destination : ");
		destination.setFont(new Font(15));
		gp.add(destination, 0, 4);

		Label capacity = new Label(" Capacity : ");
		capacity.setFont(new Font(15));
		gp.add(capacity, 0, 5);

		TextField numTF = new TextField();
		numTF.setPromptText(" Flight Number ");
		numTF.setPrefColumnCount(20);
		gp.add(numTF, 1, 1);

		TextField nameTF = new TextField();
		nameTF.setPrefColumnCount(20);
		nameTF.setPromptText(" Airline Name ");
		gp.add(nameTF, 1, 2);

		TextField sourceTF = new TextField();
		sourceTF.setPrefColumnCount(20);
		sourceTF.setPromptText(" Source ");
		gp.add(sourceTF, 1, 3);

		TextField destinationTF = new TextField();
		destinationTF.setPrefColumnCount(20);
		destinationTF.setPromptText(" Destination ");
		gp.add(destinationTF, 1, 4);

		TextField capacityTF = new TextField();
		capacityTF.setPrefColumnCount(20);
		capacityTF.setPromptText("  Capacity ");
		gp.add(capacityTF, 1, 5);

		ImageView findIm = new ImageView("https://img.icons8.com/color/344/search.png");
		findIm.setFitWidth(30);
		findIm.setFitHeight(30);
		Button findB = new Button("Find", findIm);
		findB.setTranslateX(200);
		findB.setTranslateY(120);
		findB.setPrefSize(100, 80);
		findB.setStyle("-fx-border-color:pink");
		gp.add(findB, 0, 6);

		ImageView updateIm = new ImageView("https://img.icons8.com/fluency/344/approve-and-update.png");
		updateIm.setFitWidth(30);
		updateIm.setFitHeight(30);
		Button updateB = new Button("Update", updateIm);
		updateB.setTranslateX(200);
		updateB.setTranslateY(120);
		updateB.setPrefSize(100, 80);
		updateB.setStyle("-fx-border-color:pink");
		gp.add(updateB, 1, 6);

		ImageView addIm = new ImageView("https://img.icons8.com/color/344/add.png");
		addIm.setFitWidth(30);
		addIm.setFitHeight(30);
		Button addB = new Button("Add", addIm);
		addB.setTranslateX(150);
		addB.setTranslateY(120);
		addB.setPrefSize(100, 80);
		addB.setStyle("-fx-border-color:pink");
		gp.add(addB, 2, 6);

		ImageView backIm = new ImageView("https://img.icons8.com/fluency/344/circled-left-2.png");
		backIm.setFitWidth(30);
		backIm.setFitHeight(30);
		Button backB = new Button("Back", backIm);
		backB.setTranslateX(200);
		backB.setTranslateY(120);
		backB.setPrefSize(100, 80);
		backB.setStyle("-fx-border-color:pink");
		gp.add(backB, 3, 6);

		gp.setVgap(50);

		findB.setOnAction(a -> {

		});

		updateB.setOnAction(a -> {

		});

		addB.setOnAction(a -> {

		});

		backB.setOnAction(b -> {
			try {
				list(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		Scene scene = new Scene(gp, 1500, 800);
		stage.setScene(scene);
		stage.setTitle(" * Flights List * ");
		stage.show();
	}

	public void reserveTicket(Stage stage) throws Exception {
		GridPane gp = new GridPane();

		Label topLabel = new Label(" Reserve Ticket ");
		topLabel.setFont(new Font(20));
		topLabel.setStyle("-fx-background-color: pink; -fx-padding: 20px;");
		gp.add(topLabel, 0, 0);
		gp.setAlignment(Pos.TOP_CENTER);

		Label num = new Label(" Flight Number : ");
		num.setFont(new Font(15));
		gp.add(num, 0, 1);

		Label numP = new Label(" Passport Number : ");
		numP.setFont(new Font(15));
		gp.add(numP, 0, 2);

		Label name = new Label(" Full Name : ");
		name.setFont(new Font(15));
		gp.add(name, 0, 3);

		Label ticketNumber = new Label(" Ticket Number : ");
		ticketNumber.setFont(new Font(15));
		gp.add(ticketNumber, 0, 4);

		Label nationality = new Label(" Nationality : ");
		nationality.setFont(new Font(15));
		gp.add(nationality, 0, 5);

		Label birthdate = new Label(" Birthdate : ");
		birthdate.setFont(new Font(15));
		gp.add(birthdate, 0, 6);

		TextField numTF = new TextField();
		numTF.setPromptText(" Flight Number ");
		numTF.setPrefColumnCount(20);
		gp.add(numTF, 1, 1);

		TextField numPTF = new TextField();
		numPTF.setPromptText(" Passport Number ");
		numPTF.setPrefColumnCount(20);
		gp.add(numPTF, 1, 2);

		TextField nameTF = new TextField();
		nameTF.setPrefColumnCount(20);
		nameTF.setPromptText(" Full Name ");
		gp.add(nameTF, 1, 3);

		TextField TicketNumberTF = new TextField();
		TicketNumberTF.setPrefColumnCount(20);
		TicketNumberTF.setPromptText(" Ticket Number ");
		gp.add(TicketNumberTF, 1, 4);

		TextField NationalityTF = new TextField();
		NationalityTF.setPrefColumnCount(20);
		NationalityTF.setPromptText(" Nationality ");
		gp.add(NationalityTF, 1, 5);

		TextField BirthdateTF = new TextField();
		BirthdateTF.setPrefColumnCount(20);
		BirthdateTF.setPromptText("  Birthdate ");
		gp.add(BirthdateTF, 1, 6);

		ImageView reserveIm = new ImageView("https://img.icons8.com/color/344/add.png");
		reserveIm.setFitWidth(30);
		reserveIm.setFitHeight(30);
		Button reserveB = new Button("Reserve", reserveIm);
		reserveB.setTranslateX(150);
		reserveB.setTranslateY(120);
		reserveB.setPrefSize(100, 80);
		reserveB.setStyle("-fx-border-color:pink");
		gp.add(reserveB, 0, 6);

		ImageView backIm = new ImageView("https://img.icons8.com/fluency/344/circled-left-2.png");
		backIm.setFitWidth(30);
		backIm.setFitHeight(30);
		Button backB = new Button("Back", backIm);
		backB.setTranslateX(200);
		backB.setTranslateY(120);
		backB.setPrefSize(100, 80);
		backB.setStyle("-fx-border-color:pink");
		gp.add(backB, 1, 6);

		gp.setVgap(50);

		reserveB.setOnAction(a -> {
			passenger.addFirst(new Passenger(numTF.getText(), numPTF.getText(), nameTF.getText(),
					TicketNumberTF.getText(), NationalityTF.getText(), BirthdateTF.getText()));
			System.out.println(passenger.toString());
			try {

				if (outputFile.createNewFile()) {
					System.out.println("File created: " + outputFile.getName());
				} else {
					System.out.println("File already exists.");
				}
				FileWriter myWriter = new FileWriter("out.txt");
				for (int i = 0; i < passenger.getSize(); i++) {
					myWriter.write(passenger.get(i).toString() + "\n");
				}
				myWriter.close();
			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		});

		backB.setOnAction(b -> {
			try {
				list(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		Scene scene = new Scene(gp, 1500, 800);
		stage.setScene(scene);
		stage.setTitle(" * passenger List * ");
		stage.show();
	}

	public void CancelReserve(Stage stage) throws Exception {
		GridPane gp = new GridPane();

		Label topLabel = new Label(" Cancel Reserve  ");
		topLabel.setFont(new Font(20));
		topLabel.setStyle("-fx-background-color: pink; -fx-padding: 20px;");
		gp.add(topLabel, 0, 0);
		gp.setAlignment(Pos.TOP_CENTER);

		Label num = new Label(" Flight Number : ");
		num.setFont(new Font(15));
		gp.add(num, 0, 1);

		Label name = new Label(" Full Name : ");
		name.setFont(new Font(15));
		gp.add(name, 0, 2);

		Label text = new Label();
		text.setFont(new Font(15));
		gp.add(text, 1, 3);

		TextField numTF = new TextField();
		numTF.setPromptText(" Flight Number ");
		numTF.setPrefColumnCount(20);
		gp.add(numTF, 1, 1);

		TextField nameTF = new TextField();
		nameTF.setPrefColumnCount(20);
		nameTF.setPromptText(" Full Name ");
		gp.add(nameTF, 1, 2);

		ImageView saerchIm = new ImageView("https://img.icons8.com/color/344/search.png");
		saerchIm.setFitWidth(30);
		saerchIm.setFitHeight(30);
		Button saerchB = new Button("Saerch", saerchIm);
		saerchB.setTranslateX(200);
		saerchB.setTranslateY(120);
		saerchB.setPrefSize(100, 80);
		saerchB.setStyle("-fx-border-color:pink");
		gp.add(saerchB, 0, 4);

		ImageView deleteIm = new ImageView("https://img.icons8.com/fluency/344/filled-trash.png");
		deleteIm.setFitWidth(30);
		deleteIm.setFitHeight(30);
		Button deleteB = new Button("Delete", deleteIm);
		deleteB.setTranslateX(200);
		deleteB.setTranslateY(120);
		deleteB.setPrefSize(100, 80);
		deleteB.setStyle("-fx-border-color:pink");
		gp.add(deleteB, 1, 4);

		ImageView backIm = new ImageView("https://img.icons8.com/fluency/344/circled-left-2.png");
		backIm.setFitWidth(30);
		backIm.setFitHeight(30);
		Button backB = new Button("Back", backIm);
		backB.setTranslateX(200);
		backB.setTranslateY(120);
		backB.setPrefSize(100, 80);
		backB.setStyle("-fx-border-color:pink");
		gp.add(backB, 2, 4);
		gp.setVgap(20);

		deleteB.setOnAction(b -> {

		});

		saerchB.setOnAction(b -> {
//			LinkedListP passengers= listF.search(numFTF.getText());
//			String passengersDetails = null;
//            for(int s=0; s<passengers.getSize()-1 ; s++) {
//            
//				 passengersDetails= passengersDetails+ passengers.get(s).toString()+"\n";
//				System.out.println(passengersDetails);
//				
//			}
		});

		backB.setOnAction(b -> {
			try {
				list(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		Scene scene = new Scene(gp, 1500, 800);
		stage.setScene(scene);
		stage.setTitle(" * Delete List * ");
		stage.show();
	}

	public void check(Stage stage) throws Exception {
		GridPane gp = new GridPane();

		Label topLabel = new Label(" Check Ticket  ");
		topLabel.setFont(new Font(20));
		topLabel.setStyle("-fx-background-color: pink; -fx-padding: 20px;");
		gp.add(topLabel, 0, 0);
		gp.setAlignment(Pos.TOP_CENTER);

		Label num = new Label(" Flight Number : ");
		num.setFont(new Font(15));
		gp.add(num, 0, 1);

		Label name = new Label(" Full Name : ");
		name.setFont(new Font(15));
		gp.add(name, 0, 2);

		Label text = new Label();
		text.setFont(new Font(15));
		gp.add(text, 1, 3);

		TextField numTF = new TextField();
		numTF.setPromptText(" Flight Number ");
		numTF.setPrefColumnCount(20);
		gp.add(numTF, 1, 1);

		TextField nameTF = new TextField();
		nameTF.setPrefColumnCount(20);
		nameTF.setPromptText(" Full Name ");
		gp.add(nameTF, 1, 2);

		ImageView checkIm = new ImageView("https://img.icons8.com/color/344/search.png");
		checkIm.setFitWidth(30);
		checkIm.setFitHeight(30);
		Button checkB = new Button("Check", checkIm);
		checkB.setTranslateX(200);
		checkB.setTranslateY(120);
		checkB.setPrefSize(100, 80);
		checkB.setStyle("-fx-border-color:pink");
		gp.add(checkB, 0, 4);

		ImageView backIm = new ImageView("https://img.icons8.com/fluency/344/circled-left-2.png");
		backIm.setFitWidth(30);
		backIm.setFitHeight(30);
		Button backB = new Button("Back", backIm);
		backB.setTranslateX(200);
		backB.setTranslateY(120);
		backB.setPrefSize(100, 80);
		backB.setStyle("-fx-border-color:pink");
		gp.add(backB, 1, 4);
		gp.setVgap(20);

		checkB.setOnAction(b -> {

		});

		backB.setOnAction(b -> {
			try {
				list(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		Scene scene = new Scene(gp, 1500, 800);
		stage.setScene(scene);
		stage.setTitle(" *Check List * ");
		stage.show();

	}

	public void searchPassenger(Stage stage) throws Exception {
		GridPane gp = new GridPane();

		Label topLabel = new Label(" Search Passengers Information ");
		topLabel.setFont(new Font(20));
		topLabel.setStyle("-fx-background-color: pink; -fx-padding: 20px;");
		gp.add(topLabel, 0, 0);
		gp.setAlignment(Pos.TOP_CENTER);

		Label num = new Label(" Flight Number : ");
		num.setFont(new Font(15));
		gp.add(num, 0, 1);

		Label numP = new Label(" Passport Number : ");
		numP.setFont(new Font(15));
		gp.add(numP, 0, 2);

		Label name = new Label(" Full Name : ");
		name.setFont(new Font(15));
		gp.add(name, 0, 3);

		Label ticketNumber = new Label(" Ticket Number : ");
		ticketNumber.setFont(new Font(15));
		gp.add(ticketNumber, 0, 4);

		Label nationality = new Label(" Nationality : ");
		nationality.setFont(new Font(15));
		gp.add(nationality, 0, 5);

		Label birthdate = new Label(" Birthdate : ");
		birthdate.setFont(new Font(15));
		gp.add(birthdate, 0, 6);

		TextField numTF = new TextField();
		numTF.setPromptText(" Flight Number ");
		numTF.setPrefColumnCount(20);
		gp.add(numTF, 1, 1);

		TextField numPTF = new TextField();
		numPTF.setPromptText(" Passport Number ");
		numPTF.setPrefColumnCount(20);
		gp.add(numPTF, 1, 2);

		TextField nameTF = new TextField();
		nameTF.setPrefColumnCount(20);
		nameTF.setPromptText(" Full Name ");
		gp.add(nameTF, 1, 3);

		TextField TicketNumberTF = new TextField();
		TicketNumberTF.setPrefColumnCount(20);
		TicketNumberTF.setPromptText(" Ticket Number ");
		gp.add(TicketNumberTF, 1, 4);

		TextField NationalityTF = new TextField();
		NationalityTF.setPrefColumnCount(20);
		NationalityTF.setPromptText(" Nationality ");
		gp.add(NationalityTF, 1, 5);

		TextField BirthdateTF = new TextField();
		BirthdateTF.setPrefColumnCount(20);
		BirthdateTF.setPromptText("  Birthdate ");
		gp.add(BirthdateTF, 1, 6);

		ImageView saerchIm = new ImageView("https://img.icons8.com/color/344/search.png");
		saerchIm.setFitWidth(30);
		saerchIm.setFitHeight(30);
		Button saerchB = new Button("Saerch", saerchIm);
		saerchB.setTranslateX(200);
		saerchB.setTranslateY(120);
		saerchB.setPrefSize(100, 80);
		saerchB.setStyle("-fx-border-color:pink");
		gp.add(saerchB, 0, 6);

		ImageView backIm = new ImageView("https://img.icons8.com/fluency/344/circled-left-2.png");
		backIm.setFitWidth(30);
		backIm.setFitHeight(30);
		Button backB = new Button("Back", backIm);
		backB.setTranslateX(200);
		backB.setTranslateY(120);
		backB.setPrefSize(100, 80);
		backB.setStyle("-fx-border-color:pink");
		gp.add(backB, 1, 6);

		gp.setVgap(50);

		saerchB.setOnAction(a -> {

		});

		backB.setOnAction(b -> {
			try {
				list(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		Scene scene = new Scene(gp, 1500, 800);
		stage.setScene(scene);
		stage.setTitle(" * passenger List * ");
		stage.show();
	}

}
