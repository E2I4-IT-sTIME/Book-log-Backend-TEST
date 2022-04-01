package com.itstime.Booklog.config.auth;

import com.itstime.Booklog.model.User;
import com.itstime.Booklog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User principal = userRepository.findByUsername(username)
                .orElseThrow(()->{
                   return new UsernameNotFoundException(username + " 의 해당 사용자를 찾을 수 없습니다.");
                });

        return new PrincipalDetails(principal);
    }
}
