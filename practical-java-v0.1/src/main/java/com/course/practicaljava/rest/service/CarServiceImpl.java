package com.course.practicaljava.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.course.practicaljava.rest.domain.Car;
import com.course.practicaljava.rest.domain.Engine;
import com.course.practicaljava.rest.domain.Tire;
import com.course.practicaljava.util.RandomDateUtil;


@Service
public class CarServiceImpl implements CarService {
	
	private Random random = new Random();

	@Override
	public Car generateCar() {
		
		List<String> BRANDS = new ArrayList<String>();
		BRANDS.add("Toyota");
		BRANDS.add("Honda");
		BRANDS.add("Ford");
		BRANDS.add("Mitsubushi");
		BRANDS.add("Chevrolet");
		
		List<String> COLORS = new ArrayList<String>();
		COLORS.add("Red");
		COLORS.add("Black");
		COLORS.add("White");
		COLORS.add("Blue");
		COLORS.add("Silver");
		
		List<String> TYPES = new ArrayList<String>();
		TYPES.add("Sedan");
		TYPES.add("SUV");
		TYPES.add("MPV");
		TYPES.add("Truck");
		TYPES.add("Coupe");
		
		List<String> ADDITIONAL_FEATURES = new ArrayList<String>();
		ADDITIONAL_FEATURES.add("GPS");
		ADDITIONAL_FEATURES.add("Alarm");
		ADDITIONAL_FEATURES.add("Sunroof");
		ADDITIONAL_FEATURES.add("Media player");
		ADDITIONAL_FEATURES.add("Leather seats");
		
		List<String> FUEL_TYPES = new ArrayList<String>();
		FUEL_TYPES.add("Petrol");
		FUEL_TYPES.add("Electric");
		FUEL_TYPES.add("Hybrid");
		
		List<String> TIRE_MANUFACTURERS = new ArrayList<String>();
		TIRE_MANUFACTURERS.add("Goodyear");
		TIRE_MANUFACTURERS.add("Bridgestone");
		TIRE_MANUFACTURERS.add("Dunlop");
		
		String randomBrand = BRANDS.get(random.nextInt(BRANDS.size()));
		String randomColor = COLORS.get(random.nextInt(COLORS.size()));
		String randomType = TYPES.get(random.nextInt(TYPES.size()));
		
		Car car = new Car(randomBrand, randomColor, randomType);
		
		car.setAvailable(random.nextBoolean());
		car.setPrice(5000+random.nextInt(7001));
		car.setFirstReleaseDate(RandomDateUtil.generateRandomDate());
		
		int randomCount = random.nextInt(ADDITIONAL_FEATURES.size());
		ArrayList<String> additionalFeatures = new ArrayList<String>();
		for(int i = 1; i < randomCount; i++)
		{
			additionalFeatures.add(ADDITIONAL_FEATURES.get(i-1));
		}
		
		car.setAdditionalFeatures(additionalFeatures);
		
		String randomFuelType = FUEL_TYPES.get(random.nextInt(FUEL_TYPES.size()));
		int randomHorsePower = 100 + random.nextInt(121);
		Engine randomEngine = new Engine(randomFuelType, randomHorsePower);
		car.setEngine(randomEngine);
		
		List<Tire> randomcompatibleTires = new ArrayList<Tire>();
		for(int i = 0; i < 3; i++)
		{
			String tireManufacturer = TIRE_MANUFACTURERS.get(random.nextInt(TIRE_MANUFACTURERS.size()));
			int tireSize = 15 + random.nextInt(3);
			int tirePrice = 200 + random.nextInt(201);
			
			Tire randomTire = new Tire(tireManufacturer,tireSize,tirePrice);
			randomcompatibleTires.add(randomTire);
		}
		
		car.setCompatibleTires(randomcompatibleTires);
		
		
		return car;
	}

}
