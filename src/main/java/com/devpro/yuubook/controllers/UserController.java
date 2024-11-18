package com.devpro.yuubook.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.devpro.yuubook.models.dto.AjaxResponse;
import com.devpro.yuubook.models.entities.User;
import com.devpro.yuubook.models.entities.UserAddress;
import com.devpro.yuubook.repositories.ProvinceRepo;
import com.devpro.yuubook.services.UserAddressService;
import com.devpro.yuubook.services.UserService;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/profile")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;
    @Autowired
    private ProvinceRepo provinceRepo;
    @Autowired
    private UserAddressService userAddressService;

    @GetMapping("")
    public String index(ModelMap model) {
        model.addAttribute("user", userLogin());
        model.addAttribute("userAddress", userAddressService.getUserAddressByUserLogin(userLogin()));
        return "user/profile";
    }

    @GetMapping("/personal/info")
    public String personalInformation(ModelMap model) {
        model.addAttribute("user", userService.getUserByEmail(userLogin().getEmail()));
        return "user/personal-info";
    }

    @GetMapping("/address")
    public String userAddress(ModelMap model) {
        model.addAttribute("province", provinceRepo.findAll());
        model.addAttribute("userAddress", userAddressService.getUserAddressByUserLogin(userLogin()));
        return "user/user-address";
    }

    @PostMapping("/save-profile")
    public ResponseEntity<AjaxResponse> saveProfile(ModelMap model, @RequestBody User user)
            throws IllegalStateException, IOException {
        userService.update(user);
        return ResponseEntity.ok(new AjaxResponse("Cập nhật thành công.", 200));
    }

    @PostMapping("/save-address")
    public ResponseEntity<AjaxResponse> saveUserAddress(ModelMap model, @RequestBody UserAddress userAddress)
            throws IllegalStateException, IOException {
        userAddressService.save(userAddress, userLogin());
        return ResponseEntity.ok(new AjaxResponse("Cập nhật thành công.", 200));
    }


    @PostMapping("/upload")
    public ResponseEntity<AjaxResponse> uploadAvatar(@RequestParam("file") MultipartFile file) throws IOException {

        User user = userService.updateAvatar(file, userLogin());
        if (user != null)
            return ResponseEntity.ok(new AjaxResponse("SUCCESS", 200));
        return ResponseEntity.ok(new AjaxResponse("ERROR", 400));
    }
}
