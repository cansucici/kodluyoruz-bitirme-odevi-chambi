package org.kodluyoruz.group1.library.security.config;

import lombok.RequiredArgsConstructor;
import org.kodluyoruz.group1.library.dao.MemberRepository;
import org.kodluyoruz.group1.library.model.entities.Member;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberDetailsService implements UserDetailsService {

   private final MemberRepository memberRepository;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Member> member = memberRepository.findByUserName(userName);

        member.orElseThrow(() -> new UsernameNotFoundException("Not Found:" + userName));

        return member.map(MemberDetails:: new).get();


    }
}
