package re.cntt4.museum_artifact_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import re.cntt4.museum_artifact_management.model.Artifact;


public interface IArtifactRepository extends JpaRepository<Artifact,Long> {}
