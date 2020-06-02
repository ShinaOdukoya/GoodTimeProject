package com.goodTime.domainobject;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Service
public class JWTokenGenerator {

	private static final long EXPIRATION_TIME = 864_000_000; // 1 Day in milli seconds
	private static final String SIGNING_KEY = "SecretKey";
	private static final String PREFIX = "Bearer";

	// Add token to Authorization header
	public static String addToken(HttpServletResponse res ,Authentication auth) {

		Claims claims = Jwts.claims().setSubject(auth.getName());
		String authorities = auth.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.collect(Collectors.joining(","));
		System.out.println(authorities);
		claims.put("roles", authorities);

		String JwtToken = Jwts.builder().setClaims(claims)
//				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SIGNING_KEY).compact();

		res.addHeader("Authorization", PREFIX + " " + JwtToken);
		res.addHeader("Access-Control-Expose-Headers", "Authorization");
		return JwtToken;

	}

	// Get token from Authorization header
	public static Authentication getAuthentication(HttpServletRequest request) {

		String token = request.getHeader("Authorization");

		if (token != null) {

			Claims claims = Jwts.parser().setSigningKey(SIGNING_KEY).parseClaimsJws(token.replace(PREFIX, ""))
					.getBody();
			String user = claims.getSubject();

			Collection<GrantedAuthority> authorities = Arrays.stream(claims.get("roles").toString().split(","))
					.map(SimpleGrantedAuthority::new).collect(Collectors.toList());

			if (user != null) {
				return new UsernamePasswordAuthenticationToken(user, null, authorities);
			}

		}

		return null;

	}

}
