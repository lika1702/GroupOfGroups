package course.groupofgroups.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import course.groupofgroups.service.ProfileService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;
import org.cloudinary.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProfileController {

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private ProfileService service;

    @PostMapping(value = "/profile/image")
    public String uploadPhoto(
            @RequestParam(value = "photo", required = true) MultipartFile file,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "id") Long id) throws IOException {
        File f = Files.createTempFile("temp", file.getOriginalFilename()).toFile();
        file.transferTo(f);
        Map uploadResult = cloudinary.uploader().upload(f, ObjectUtils.emptyMap());
        JSONObject json = new JSONObject(uploadResult);
        String url = json.getString("url");
        service.setPhoto(url, id);
        return "redirect:/profile/" + email;
    }

}
