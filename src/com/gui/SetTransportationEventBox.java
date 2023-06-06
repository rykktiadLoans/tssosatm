package com.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;

import java.io.Serializable;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * A class that represents the transportation event whose arrival time is set by the user.
 *  Implements the EventBox and Serializable interfaces
 */
public class SetTransportationEventBox implements EventBox, Serializable{
	transient private GridPane box = null;
	private String type;
	private String name;
	private LocalTime departure;
	private LocalTime arrival;
	transient private Label typeLabel;
	transient private Label nameLabel;
	transient private Label timeLabel;
	
	/**
	 * Return the list of types
	 * @return Return the arraylist of strings of types
	 */
	public static ArrayList<String> getTypeList(){
		ArrayList<String> typeList = new ArrayList<String>();
		typeList = new ArrayList<String>();
		typeList.add("Bus");
		typeList.add("Tram");
		typeList.add("Metro");
		typeList.add("Plane");
		typeList.add("Ferry");
		typeList.add("Ship");
		typeList.add("Barge");
		typeList.add("Trawler");
		typeList.add("Train");
		typeList.add("Public Transit");
		return typeList;
	}
	
	/**
	 * 
	 * @param type Type of the event
	 * @param name Name of the event
	 * @param departure Departure time of the event
	 * @param arrival Arrival time of the event
	 */
	public SetTransportationEventBox(String type, String name, LocalTime departure, LocalTime arrival){
		
		this.type = type;
		this.name = name;
		this.departure = departure;
		this.arrival = arrival;
		this.box = new GridPane();
		box.getRowConstraints().add(new RowConstraints(50));
		box.getColumnConstraints().add(new ColumnConstraints(80));
		box.getColumnConstraints().add(new ColumnConstraints(290));
		box.getColumnConstraints().add(new ColumnConstraints(50));
		box.setPadding(new Insets(0,0,0,10));
		box.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY,null,null) ));
		this.typeLabel = new Label(type);
		this.nameLabel = new Label(name);
		this.timeLabel = new Label(departure.format(DateTimeFormatter.ofPattern("HH:mm")) + "\n" + arrival.format(DateTimeFormatter.ofPattern("HH:mm")));
		GridPane.setConstraints(typeLabel, 0, 0);
		GridPane.setConstraints(nameLabel, 1, 0);
		GridPane.setConstraints(timeLabel, 2, 0);
		this.typeLabel.setTextFill(Color.DEEPPINK);

		
		box.getChildren().addAll(this.typeLabel, this.nameLabel, this.timeLabel);
	}
	
	/** Returns the JavaFX region of the event
	 * 
	 * @return Returns the JavaFX region of the event
	 */
	@Override
	public Region getBox() {
		return this.box;
	}
	
	/** Returns the name of the event as a string
	 * 
	 * @return Returns the name of the event as a string
	 */
	@Override
	public String getName() {
		return this.name;
	}
	
	/** Returns the departure time of the event
	 * 
	 * @return Returns the departure time of the event
	 */
	@Override
	public LocalTime getDeparture() {
		return this.departure;
	}
	
	/** Returns the arrival time of the event
	 * 
	 * @return Returns the arrival time of the event
	 */
	@Override
	public LocalTime getArrival() {
		return this.arrival;
	}

	/** Returns an array of strings that has all the properties of the event
	 * 
	 * @return Returns an array of strings that has all the properties of the event: class of event, type, name, departure time,
	 *  and the fourth property depending on the class
	 */
	@Override
	public ArrayList<String> getEditable() {
		ArrayList<String> al = new ArrayList<String>();
		al.add("Set");
		al.add(this.type);
		al.add(this.name);
		al.add(this.departure.format(DateTimeFormatter.ofPattern("HH:mm")));
		al.add(this.arrival.format(DateTimeFormatter.ofPattern("HH:mm")));
		return al;
	}
	
	/** Returns the type of the event as a string
	 * 
	 * @return Returns the type of the event as a string
	 */
	@Override
	public String getType() {
		return this.type;
	}
}
