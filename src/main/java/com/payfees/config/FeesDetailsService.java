package com.payfees.config;
import com.payfees.entity.Fees;
import com.payfees.repository.FeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FeesDetailsService implements UserDetailsService {

    @Autowired
    private FeesRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Fees> user = repository.findById(email);
        try {
        	return user.map(FeesDetails::new)
                    .orElseThrow(() -> new UsernameNotFoundException("user not found " + email));
			
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			return null;
		}
    }
}
