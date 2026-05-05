package re.cntt4.museum_artifact_management.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import re.cntt4.museum_artifact_management.dto.ArtifactDTO;
import re.cntt4.museum_artifact_management.model.Artifact;
import re.cntt4.museum_artifact_management.service.impl.ArtifactIMPL;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class ArtifactController {
    private final ArtifactIMPL artifactIMPL;
    
    @GetMapping
    public String home(
            Model model
    ){
        model.addAttribute("artifact",artifactIMPL.getAll());
        return "home";
    }

    @GetMapping("/add")
    public String viewAdd(
            Model model
    ){
        model.addAttribute("artifactDTO",new ArtifactDTO());
        return "view-add";
    }

    @PostMapping("/handleAdd")
    public String handleAdd(
            @Valid @ModelAttribute("artifactDTO") ArtifactDTO artifactDTO,
            BindingResult br,
            Model model
    ){
        if (br.hasErrors()){
            model.addAttribute("artifactDTO" , artifactDTO);
            return "view-add";
        }
        Artifact newArtifact = Artifact.builder()
                .name(artifactDTO.getName())
                .origin(artifactDTO.getOrigin())
                .date(artifactDTO.getDate())
                .build();
        artifactIMPL.save(newArtifact);
        return "redirect:/";
    }

    // xoa
    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable(name = "id") Long id
    ){
        artifactIMPL.delete(id);
        return "redirect:/";
    }

    // cap nhat
    @GetMapping("/update/{id}")
    public String update(
            @PathVariable(name = "id") Long id ,
            Model model
    ){

        Artifact artifact = artifactIMPL.findById(id);
        if (artifact == null) return "redirect:/";
        ArtifactDTO dto = new ArtifactDTO();
        dto.setId(artifact.getId());
        dto.setName(artifact.getName());
        dto.setOrigin(artifact.getOrigin());
        dto.setDate(artifact.getDate());

        model.addAttribute("artifactDTO",dto);

        return "view-update";
    }

    @PostMapping("/handleUpdate")
    public String handleUpdate(
            @Valid @ModelAttribute(name = "artifactDTO") ArtifactDTO dto,
            BindingResult br,
            Model model
    ){
        if (br.hasErrors()){
            model.addAttribute("artifactDTO",dto);
            return "view-update";
        }
        Artifact artifact = artifactIMPL.findById(dto.getId());
        if (artifact == null) return "redirect:/";
        artifact.setName(dto.getName());
        artifact.setOrigin(dto.getOrigin());
        artifact.setDate(dto.getDate());

        artifactIMPL.save(artifact);
        return "redirect:/";
    }
}
