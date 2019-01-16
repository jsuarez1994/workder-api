package com.workderapi;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.workderapi.entity.*;
import com.workderapi.services.*;

@SpringBootApplication
public class WorkderApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkderApiApplication.class, args);
	}

}

