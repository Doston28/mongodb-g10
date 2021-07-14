package pdp.uz.mongodbg10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import pdp.uz.mongodbg10.model.Video;
import pdp.uz.mongodbg10.service.VideoService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/api")
public class VideoController {

    @Autowired
    VideoService videoService;

    @PostMapping("/videos/add")
    public String addVideo(@RequestParam("title") String title,
                           @RequestParam("file") MultipartFile file, Model model) throws IOException {
        String id = videoService.addVideo(title, file);
        return "redirect:/videos/" + id;
    }

    @GetMapping("/videos/{id}")
    public String getVideo(@PathVariable String id, Model model) throws Exception {
            Video video = videoService.getVideo(id);
        model.addAttribute("title", video.getTitle());
        model.addAttribute("url", "http://localhost:8080/api/videos/stream/" + id);
        return "videos";
    }

    @GetMapping("/videos/stream/{id}")
    public void streamVideo(@PathVariable String id, HttpServletResponse response) throws Exception {
        Video video = videoService.getVideo(id);
        FileCopyUtils.copy(video.getStream(), response.getOutputStream());
    }
}
