package com.turtlevoice.voiceforensic.repository;

import com.turtlevoice.voiceforensic.entity.RecordFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordFileRepository extends JpaRepository<RecordFile, Long> {
}
