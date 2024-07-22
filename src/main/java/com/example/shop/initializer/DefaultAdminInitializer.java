package com.example.shop.initializer;

import com.example.shop.entities.Role;
import com.example.shop.entities.User;
import com.example.shop.services.IRoleService;
import com.example.shop.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DefaultAdminInitializer implements CommandLineRunner {

    private final IUserService iUserService;
//    private final PasswordEncoder passwordEncoder;
    private final IRoleService roleService;

    @Autowired
    public DefaultAdminInitializer(IUserService userService, PasswordEncoder passwordEncoder, IRoleService roleService) {
        this.iUserService = userService;
//        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Tạo vai trò mặc định
        createDefaultRoles();

        // Tạo tài khoản admin mặc định
        createDefaultAdmin();

        // Tạo tài khoản quản lý mặc định
        createDefaultManager();
    }

    private void createDefaultRoles() {
        String[] roleNames = {"ROLE_ADMIN", "ROLE_MANAGER", "ROLE_SALESMAN", "ROLE_WAREHOUSE"};
        for (String roleName : roleNames) {
            Role role = roleService.findByName(roleName);
            if (role == null) {
                role = new Role();
                role.setName(roleName);
                roleService.save(role);
            }
        }
    }

    private void createDefaultAdmin() {
        if (!iUserService.existsByUsername("admin")) {
            Role adminRole = roleService.findByName("ROLE_ADMIN");
            User admin = new User();
            admin.setUsername("admin");
            admin.setCode("ADMIN");
            admin.setPassword("8888");
            admin.setRole(adminRole);
            admin.setName("Le Van Quy");
            admin.setAvatarUrl("/assets/images/avatars/avatar_25.jpg");
            admin.setEmail("quyle.01012002@gmail.com");
            admin.setDate(LocalDate.now());
            admin.setGender(0);
            admin.setEnabled(true);
            iUserService.save(admin);
        }
    }

    private void createDefaultManager() {
        if (!iUserService.existsByUsername("lvq")) {
            Role managerRole = roleService.findByName("ROLE_MANAGER");
            User manager = new User();
            manager.setUsername("lvq");
            manager.setPassword("1234");
            manager.setCode("MN-001");
            manager.setRole(managerRole);
            manager.setName("Lê Văn Quý");
            manager.setGender(0);
            manager.setAvatarUrl("https://avatars.githubusercontent.com/u/138227498?s=400&u=933ddd7cd94991150a3267b8e3965aeb21be2b31&v=4");
            manager.setEmail("quyle.01012002@gmail.com");
            manager.setAddress("Hải Châu - Đà Nẵng");
            manager.setDate(LocalDate.now());
            manager.setDob(LocalDate.of(2002, 1, 1));
            manager.setPhone("0859737366");
            manager.setEnabled(true);
            iUserService.save(manager);
        }
    }
}
