package re.cntt4.museum_artifact_management.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import re.cntt4.museum_artifact_management.model.Artifact;
import re.cntt4.museum_artifact_management.repository.IArtifactRepository;
import re.cntt4.museum_artifact_management.service.IArtifactService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ArtifactIMPL implements IArtifactService {
    private final IArtifactRepository repository;

    @Override
    public List<Artifact> getAll() {
        return repository.findAll();
    }
    @Override
    public void save(Artifact artifact) {
        repository.save(artifact);
    }
    @Override
    public Artifact findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }


}
