package re.cntt4.museum_artifact_management.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import re.cntt4.museum_artifact_management.model.Artifact;

import java.util.List;

public interface IArtifactService {
    List<Artifact> getAll();

    void save(Artifact artifact);

    Artifact findById(Long id);

    void delete(Long id);

}
