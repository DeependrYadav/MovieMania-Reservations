package com.moviesmania.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class CinemaHall {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cinemaHallId;
	
	@NotNull(message = "Provide total seats.")
	private Integer totalSeats;
	
	@NotNull(message = "Provide total seats per row.")
	private Integer seatsPerRow;
	
	@NotNull(message = "Provide total seats per column.")
	private Integer seatsPerColumn;
	
	@NotNull(message = "Provide show details.")
	@ManyToOne
	private MovieShow show;
	
	@ElementCollection
	private List<CinemaHallSeat> hallSeats = new ArrayList<>();
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Cinema cinema;

	public CinemaHall(Integer totalSeats, Integer seatsPerRow, Integer seatsPerColumn, MovieShow show,
			Cinema cinema) {
		super();
		this.totalSeats = totalSeats;
		this.seatsPerRow = seatsPerRow;
		this.seatsPerColumn = seatsPerColumn;
		this.show = show;
		this.cinema = cinema;
		fillHallSeatsDetails(seatsPerRow,seatsPerColumn);
	}
	
	private void fillHallSeatsDetails(Integer seatsPerRow, Integer seatsPerColumn) {
		
		for(int i = 0; i < seatsPerRow; i++) {
			for(int j = 0; j < seatsPerColumn; j++) {
				if(i <= seatsPerColumn/3) {
					hallSeats.add(new CinemaHallSeat("S"+i+j, false,130.00,SeatType.Regular));
				}else if(i <= seatsPerColumn/3*2) {
					hallSeats.add(new CinemaHallSeat("S"+i+j, false,150.00,SeatType.Premium));					
				}else if(i < seatsPerColumn && j < seatsPerColumn/2) {
					hallSeats.add(new CinemaHallSeat("S"+i+j, false,200.00,SeatType.Left_Balconey));					
				}else if(i < seatsPerColumn && j > seatsPerColumn/2) {
					hallSeats.add(new CinemaHallSeat("S"+i+j, false,200.00,SeatType.Right_Balconey));					
				}
			}
		}
		
	}
}
