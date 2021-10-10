package com.codassassin.tourmanagement.services;

import com.codassassin.tourmanagement.model.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public interface UserDetailsService extends org.springframework.security.core.userdetails.UserDetailsService {
    UserDetails loadUserByUsername(String userName);
    List<String> getPrivileges(Collection<Role> roles);
    List<GrantedAuthority> getGrantedAuthorities(List<String> privileges);
    Collection<? extends GrantedAuthority> getAuthorities (Collection<Role> roles);
}
