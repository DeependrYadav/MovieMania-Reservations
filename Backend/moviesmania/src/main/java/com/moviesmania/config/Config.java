package com.moviesmania.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;


import jakarta.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class Config {

    @Bean
    SecurityFilterChain springSecurityConfiguration(HttpSecurity http) throws Exception {
//		Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry>
//		authorizeHttpRequestsCustomizer = a -> a.requestMatchers(HttpMethod.POST,"/customers").permitAll().anyRequest().authenticated();
		
		http.sessionManagement(se -> se.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.cors(cors -> {
			cors.configurationSource(new CorsConfigurationSource() {
				
				@Override
				public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {

					CorsConfiguration cfg = new CorsConfiguration();
					cfg.setAllowedOriginPatterns(Collections.singletonList("*"));
					cfg.setAllowedMethods(Collections.singletonList("*"));
					cfg.setAllowCredentials(true);
					cfg.setAllowedHeaders(Collections.singletonList("*"));
					cfg.setExposedHeaders(Arrays.asList("Authorization"));
					return cfg;
				}
				
			});
		})
		
		
		.authorizeHttpRequests(auth ->{
			
			auth
			.requestMatchers(HttpMethod.POST,"/user","/user/resetPassword/{email}").permitAll()
			.requestMatchers("/swagger-ui/**","/v3/api-docs/**").permitAll() // this is for JWT on Swagger
			
			.requestMatchers(HttpMethod.GET,"/viewAllMovie","/getUserByEmaili/**","/searchMovie/{text}","/viewShowByDate/{date}","/viewShowByCity/{city}").permitAll()
			
			.requestMatchers(HttpMethod.POST,"/user/createBooking/{email}/{showId}/{cinemaHallSeatName}"
					,"/pay/{email}/{amount}").hasAnyRole("FRONTDESKOFFIICE","USER")
			
			.requestMatchers(HttpMethod.POST,"/addMovie","/addCinema","/addCinemaHall/{cinemaId}",
					"/addShow/{movieId}/{cinemaHallId}").hasRole("ADMIN")
			.requestMatchers(HttpMethod.PUT,"/addMovie/{movieId}").hasRole("ADMIN")
			.requestMatchers(HttpMethod.GET,"/user/getAllBooking","/viewAllPayments","/viewAllUser",
					"/user/getBookingById/{bookingId}").hasRole("ADMIN")
			.anyRequest()
			.authenticated();
			
		})
		
		
		.csrf(csrf -> csrf.disable())
		.addFilterAfter(new JwtTokenGeneratorFilter(), BasicAuthenticationFilter.class)
		.addFilterBefore(new JwtTokenValidatorFilter(), BasicAuthenticationFilter.class)
		.formLogin(Customizer.withDefaults())
		.httpBasic(Customizer.withDefaults());
		
		return http.build();
	}

    @Bean
    PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
