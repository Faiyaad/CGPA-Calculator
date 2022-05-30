package application;
	
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class Main extends Application {
	ArrayList<String>course;
	ArrayList<String>grade;
	ArrayList<Integer>credit;
	double  grandtotal;

	public void calculation(ArrayList<String>course,ArrayList<Integer>credit,ArrayList<String>grade) throws Exception{
		File f = new File("Information.txt");
		f.createNewFile();
	FileWriter fw=new FileWriter("Information.txt");
		for(int i=0; i<course.size(); i++) {
			System.out.println(" "+course.get(i)+" "+credit.get(i)+" "+grade.get(i));
				
					
				fw.write("Course "+(i+1)+" : "+course.get(i)+"   Credit : "+String.valueOf(credit.get(i))+"   Grade : "+grade.get(i)+"\n");
				
		}
		fw.close();
		double total = 0;
		int allcr = 0;
		for(int j=0; j<5; j++) {
			
			if(grade.get(j) == "A") {
				total += credit.get(j)*4.00;
			}
			else if(grade.get(j) == "A-") {
				total += credit.get(j)*3.7;
			}
			else if(grade.get(j) == "B+") {
				total += credit.get(j)*3.3;
			}
			else if(grade.get(j) == "B") {
				total += credit.get(j)*3.00;
			}
			else if(grade.get(j) == "B-") {
				total += credit.get(j)*2.7;
			}
			else if(grade.get(j) == "C+") {
				total += credit.get(j)*2.3;
			}
			else if(grade.get(j) == "C") {
				total += credit.get(j)*2.00;
			}
			else if(grade.get(j) == "C-") {
				total += credit.get(j)*1.7;
			}
			else if(grade.get(j) == "D+") {
				total += credit.get(j)*1.3;
			}
			else if(grade.get(j) == "D") {
				total += credit.get(j)*1.00;
			}
			else if(grade.get(j) == "F") {
				total += credit.get(j)*0.0;
			}
			allcr += credit.get(j);
		}
		 grandtotal = (double)total/allcr;
		System.out.println(grandtotal);
	}
	

	@Override
	public void start(Stage primaryStage) {
		
		
		Label lbtitle = new Label("CGPA Calculator");
		lbtitle.setFont(new Font("Mosk",30));
		Label lbname = new Label("Name : ");
		lbname.setFont(new Font("Arail",15));
		Label lbid = new Label("Id : ");
		lbid.setFont(new Font("Arail",15));
		TextField tf1 = new TextField();
		TextField tf2 = new TextField();
		Button b1 = new Button("Proceed");
		
		
		b1.setOnAction(new EventHandler<ActionEvent>() {
			
			
			@Override
			public void handle(ActionEvent event) {
				String name = tf1.getText().toString();
				String id = tf2.getText().toString();
				File obj = new File("data.txt");
				try {
					obj.createNewFile();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				FileWriter fw;
				try {
					fw = new FileWriter("data.txt");
					fw.write("Name : "+name+"  Id : "+id);
					fw.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
				//ui element of page 2 
				Label lbselect = new Label("SELECT");
				lbselect.setFont(new Font("Mosk",30));
				
				
				Label lbc1 = new Label("Course 1 : ");
				lbc1.setFont(new Font("Archive",20));
				Label lbc2 = new Label("Course 2 : ");
				lbc2.setFont(new Font("Archive",20));
				Label lbc3 = new Label("Course 3 : ");
				lbc3.setFont(new Font("Archive",20));
				Label lbc4 = new Label("Course 4 : ");
				lbc4.setFont(new Font("Archive",20));
				Label lbc5 = new Label("Course 5 : ");
				lbc5.setFont(new Font("Archive",20));
			    
				
				ComboBox course1 = new ComboBox();
				course1.setPromptText("Select Course");
				course1.getItems().addAll("ENG 102","ENG 103","ENG 111","PHI 101","PHI 104","LBA 101","LBA 102","POL 101","POL 104","ECO 101","ECO 104","SOC 101","ENV 203","ANT 101",
	"BIO 103","CSE 215","CSE 215L","CSE 173","CSE 225","CSE 225L","CSE 231","CSE 231L","CSE 299","EEE 141","EEE 141L","EEE 111","EEE 111L","CSE 311","CSE 311L",
	"CSE 323","CSE 327","CSE 331","CSE 331L","CSE 332","CSE 373","CSE 325","CSE 498","CSE499A","CSE499B","CSE 417","CSE 401","CSE 418","CSE 426","CSE 473","CSE 491",
     "CSE 411","CSE 424","CSE 427","CSE 428","CSE 429","CSE 492","CSE 422","CSE 438","CSE 482","CSE 485","CSE 486","CSE 493","CSE 433","CSE 435","CSE 413","CSE 414",
	"CSE 494","CSE 419","CSE 440","CSE 445","CSE 465","CSE 467","CSE 468","CSE 470","CSE 495","CSE 446","CSE 447","CSE 448","CSE 449","CSE 496");
				
					
				course = new ArrayList<String>();
				credit = new ArrayList<Integer>();
				grade = new ArrayList<String>();
				course1.setOnAction(new EventHandler<Event>() {
@Override
					public void handle(Event event) {					
						Object selectItem1 = course1.getSelectionModel().getSelectedItem();
						
						
						course.add(String.valueOf(selectItem1));

					}

				});
				ComboBox credit1 = new ComboBox();
				credit1.setPromptText("Select Credit");
				credit1.getItems().addAll("0","1","3");
				credit1.setOnAction(new EventHandler<Event>() {
					@Override
					public void handle(Event event) {					
						Object selectItem1 = credit1.getSelectionModel().getSelectedItem();
						
						
						String cr = String.valueOf(selectItem1);
						credit.add(Integer.parseInt(cr));
					}
				});
				
				ComboBox grade1 = new ComboBox();
				grade1.setPromptText("Select grade");
				grade1.getItems().addAll("A","A-","B+","B","B-","C+","C","C-","D+","D","F");
				grade1.setOnAction(new EventHandler<Event>() {
					@Override
					public void handle(Event event) {					
						Object selectItem1 = grade1.getSelectionModel().getSelectedItem();				
						
						grade.add(String.valueOf(selectItem1));
					}
					
				});
				
				
				ComboBox course2 = new ComboBox();
				course2.setPromptText("Select Course");
				course2.getItems().addAll("ENG 102","ENG 103","ENG 111","PHI 101","PHI 104","LBA 101","LBA 102","POL 101","POL 104","ECO 101","ECO 104","SOC 101","ENV 203","ANT 101",
						"BIO 103","CSE 215","CSE 215L","CSE 173","CSE 225","CSE 225L","CSE 231","CSE 231L","CSE 299","EEE 141","EEE 141L","EEE 111","EEE 111L","CSE 311","CSE 311L",
						"CSE 323","CSE 327","CSE 331","CSE 331L","CSE 332","CSE 373","CSE 325","CSE 498","CSE499A","CSE499B","CSE 417","CSE 401","CSE 418","CSE 426","CSE 473","CSE 491",
						"CSE 411","CSE 424","CSE 427","CSE 428","CSE 429","CSE 492","CSE 422","CSE 438","CSE 482","CSE 485","CSE 486","CSE 493","CSE 433","CSE 435","CSE 413","CSE 414",
						"CSE 494","CSE 419","CSE 440","CSE 445","CSE 465","CSE 467","CSE 468","CSE 470","CSE 495","CSE 446","CSE 447","CSE 448","CSE 449","CSE 496");
				course2.setOnAction(new EventHandler<Event>() {
					@Override
					public void handle(Event event) {					
						Object selectItem2 = course2.getSelectionModel().getSelectedItem();
						//print(selectItem2);
						course.add(String.valueOf(selectItem2));
					}
					
				});
				
				
				ComboBox credit2 = new ComboBox();
				credit2.setPromptText("Select Credit");
				credit2.getItems().addAll("0","1","3");
				credit2.setOnAction(new EventHandler<Event>() {
					@Override
					public void handle(Event event) {					
						Object selectItem2 = credit1.getSelectionModel().getSelectedItem();
						//print(selectItem2);
						String cr = String.valueOf(selectItem2);
						credit.add(Integer.parseInt(cr));
					}
					
				});
				
				
				ComboBox grade2 = new ComboBox();
				grade2.setPromptText("Select grade");
				grade2.getItems().addAll("A","A-","B+","B","B-","C+","C","C-","D+","D","F");
				grade2.setOnAction(new EventHandler<Event>() {
					@Override
					public void handle(Event event) {					
						Object selectItem2 = grade2.getSelectionModel().getSelectedItem();
						//print(selectItem2);
						grade.add(String.valueOf(selectItem2));
					}
					
				});
				
				
				
				ComboBox course3 = new ComboBox();
				course3.setPromptText("Select Course");
				course3.getItems().addAll("ENG 102","ENG 103","ENG 111","PHI 101","PHI 104","LBA 101","LBA 102","POL 101","POL 104","ECO 101","ECO 104","SOC 101","ENV 203","ANT 101",
						"BIO 103","CSE 215","CSE 215L","CSE 173","CSE 225","CSE 225L","CSE 231","CSE 231L","CSE 299","EEE 141","EEE 141L","EEE 111","EEE 111L","CSE 311","CSE 311L",
						"CSE 323","CSE 327","CSE 331","CSE 331L","CSE 332","CSE 373","CSE 325","CSE 498","CSE499A","CSE499B","CSE 417","CSE 401","CSE 418","CSE 426","CSE 473","CSE 491",
						"CSE 411","CSE 424","CSE 427","CSE 428","CSE 429","CSE 492","CSE 422","CSE 438","CSE 482","CSE 485","CSE 486","CSE 493","CSE 433","CSE 435","CSE 413","CSE 414",
						"CSE 494","CSE 419","CSE 440","CSE 445","CSE 465","CSE 467","CSE 468","CSE 470","CSE 495","CSE 446","CSE 447","CSE 448","CSE 449","CSE 496");
				course3.setOnAction(new EventHandler<Event>() {
					@Override
					public void handle(Event event) {					
						Object selectItem3 = course3.getSelectionModel().getSelectedItem();
						course.add(String.valueOf(selectItem3));
					}
					
				});
				ComboBox credit3 = new ComboBox();
				credit3.setPromptText("Select Credit");
				credit3.getItems().addAll("0","1","3");
				credit3.setOnAction(new EventHandler<Event>() {
					@Override
					public void handle(Event event) {					
						Object selectItem3 = credit3.getSelectionModel().getSelectedItem();
						String cr = String.valueOf(selectItem3);
						credit.add(Integer.parseInt(cr));
					}
					
				});
				
				ComboBox grade3 = new ComboBox();
				grade3.setPromptText("Select grade");
				grade3.getItems().addAll("A","A-","B+","B","B-","C+","C","C-","D+","D","F");
				grade3.setOnAction(new EventHandler<Event>() {
					@Override
					public void handle(Event event) {					
						Object selectItem3 = grade3.getSelectionModel().getSelectedItem();
						grade.add(String.valueOf(selectItem3));
					}
					
				});
				
				ComboBox course4 = new ComboBox();
				course4.setPromptText("Select Course");
    course4.getItems().addAll("ENG 102","ENG 103","ENG 111","PHI 101","PHI 104","LBA 101","LBA 102","POL 101","POL 104","ECO 101","ECO 104","SOC 101","ENV 203","ANT 101",
	"BIO 103","CSE 215","CSE 215L","CSE 173","CSE 225","CSE 225L","CSE 231","CSE 231L","CSE 299","EEE 141","EEE 141L","EEE 111","EEE 111L","CSE 311","CSE 311L",
	"CSE 323","CSE 327","CSE 331","CSE 331L","CSE 332","CSE 373","CSE 325","CSE 498","CSE499A","CSE499B","CSE 417","CSE 401","CSE 418","CSE 426","CSE 473","CSE 491",
	"CSE 411","CSE 424","CSE 427","CSE 428","CSE 429","CSE 492","CSE 422","CSE 438","CSE 482","CSE 485","CSE 486","CSE 493","CSE 433","CSE 435","CSE 413","CSE 414",
	"CSE 494","CSE 419","CSE 440","CSE 445","CSE 465","CSE 467","CSE 468","CSE 470","CSE 495","CSE 446","CSE 447","CSE 448","CSE 449","CSE 496");
				course4.setOnAction(new EventHandler<Event>() {
					@Override
					public void handle(Event event) {					
						Object selectItem4 = course4.getSelectionModel().getSelectedItem();
						course.add(String.valueOf(selectItem4));
					}
				});
				ComboBox credit4 = new ComboBox();
				credit4.setPromptText("Select Credit");
				credit4.getItems().addAll("0","1","3");
				credit4.setOnAction(new EventHandler<Event>() {
					@Override
					public void handle(Event event) {					
						Object selectItem4 = credit4.getSelectionModel().getSelectedItem();
						String cr = String.valueOf(selectItem4);
						credit.add(Integer.parseInt(cr));
					}
					
				});
				
				ComboBox grade4 = new ComboBox();
				grade4.setPromptText("Select grade");
				grade4.getItems().addAll("A","A-","B+","B","B-","C+","C","C-","D+","D","F");
				grade4.setOnAction(new EventHandler<Event>() {
					@Override
					public void handle(Event event) {					
						Object selectItem4 = grade4.getSelectionModel().getSelectedItem();
						grade.add(String.valueOf(selectItem4));
					}
					
				});
				
				ComboBox course5 = new ComboBox();
				course5.setPromptText("Select Course");
				course5.getItems().addAll("ENG 102","ENG 103","ENG 111","PHI 101","PHI 104","LBA 101","LBA 102","POL 101","POL 104","ECO 101","ECO 104","SOC 101","ENV 203","ANT 101",
						"BIO 103","CSE 215","CSE 215L","CSE 173","CSE 225","CSE 225L","CSE 231","CSE 231L","CSE 299","EEE 141","EEE 141L","EEE 111","EEE 111L","CSE 311","CSE 311L",
						"CSE 323","CSE 327","CSE 331","CSE 331L","CSE 332","CSE 373","CSE 325","CSE 498","CSE499A","CSE499B","CSE 417","CSE 401","CSE 418","CSE 426","CSE 473","CSE 491",
						"CSE 411","CSE 424","CSE 427","CSE 428","CSE 429","CSE 492","CSE 422","CSE 438","CSE 482","CSE 485","CSE 486","CSE 493","CSE 433","CSE 435","CSE 413","CSE 414",
						"CSE 494","CSE 419","CSE 440","CSE 445","CSE 465","CSE 467","CSE 468","CSE 470","CSE 495","CSE 446","CSE 447","CSE 448","CSE 449","CSE 496");
				course5.setOnAction(new EventHandler<Event>() {
					@Override
					public void handle(Event event) {					
						Object selectItem5 = course5.getSelectionModel().getSelectedItem();
						course.add(String.valueOf(selectItem5));
					}
					
				});
				ComboBox credit5 = new ComboBox();
				credit5.setPromptText("Select Credit");
				credit5.getItems().addAll("0","1","3");
				credit5.setOnAction(new EventHandler<Event>() {
					@Override
					public void handle(Event event) {					
						Object selectItem5 = credit5.getSelectionModel().getSelectedItem();
						String cr = String.valueOf(selectItem5);
						credit.add(Integer.parseInt(cr));
					}
					
				});
				ComboBox grade5 = new ComboBox();
				grade5.setPromptText("Select grade");
				grade5.getItems().addAll("A","A-","B+","B","B-","C+","C","C-","D+","D","F");
				grade5.setOnAction(new EventHandler<Event>() {
					@Override
					public void handle(Event event) {					
						Object selectItem5 = grade5.getSelectionModel().getSelectedItem();
						grade.add(String.valueOf(selectItem5));
					}
					
				});
				
				Button bcal = new Button("Calculate");
				bcal.setFont(new Font("Mosk",20));
				bcal.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						
						try {
							calculation(course,credit,grade);
						} catch (Exception e) {
							e.printStackTrace();
						}
						Alert al = new Alert(AlertType.CONFIRMATION);
						al.setContentText(String.valueOf(grandtotal));
						al.setTitle("CGPA");
						al.setHeaderText("Name : "+name+"\nId : "+id);
						al.show();
					}
					
				});
				
				HBox hc2 = new HBox(20,lbc1,course1,credit1,grade1);
				hc2.setAlignment(Pos.CENTER);
				HBox hc3 = new HBox(20,lbc2,course2,credit2,grade2);
				hc3.setAlignment(Pos.CENTER);
				HBox hc4 = new HBox(20,lbc3,course3,credit3,grade3);
				hc4.setAlignment(Pos.CENTER);
				HBox hc5 = new HBox(20,lbc4,course4,credit4,grade4);
				hc5.setAlignment(Pos.CENTER);
				HBox hc6 = new HBox(20,lbc5,course5,credit5,grade5);
				hc6.setAlignment(Pos.CENTER);
				
				VBox vcourse = new VBox(20,hc2,hc3,hc4,hc5,hc6);
				VBox vtitle  = new VBox(lbselect);
				vtitle.setAlignment(Pos.CENTER);
				VBox vbutton  = new VBox(bcal);
				vbutton.setAlignment(Pos.CENTER);
				VBox vattach  = new VBox(20,vtitle,vcourse);
				VBox vfinal  = new VBox(35,vattach,vbutton);
				
				Scene scourse = new Scene(vfinal,900,450);
				
				//stage
				primaryStage.setScene(scourse);
				primaryStage.setTitle("CGPA Calculatoer");
				primaryStage.show();
				
			}
			
		});
		
		//layout
		HBox h0 = new HBox(lbtitle);
		h0.setAlignment(Pos.CENTER);
		HBox h1 = new HBox(20,lbname,tf1);
		h1.setAlignment(Pos.CENTER);
		HBox h2 = new HBox(45,lbid,tf2);
		h2.setAlignment(Pos.CENTER);
		HBox h3 = new HBox(b1);
		h3.setAlignment(Pos.CENTER);
		VBox v1 = new VBox(20,h0,h1,h2,h3);
		v1.setAlignment(Pos.CENTER);
		
		//scene
		Scene s = new Scene(v1,500,500);
		
		//stage
		primaryStage.setScene(s);
		primaryStage.setTitle("CGPA Calculatoer");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
