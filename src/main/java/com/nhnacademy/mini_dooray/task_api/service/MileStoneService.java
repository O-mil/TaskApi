package com.nhnacademy.mini_dooray.task_api.service;

import com.nhnacademy.mini_dooray.task_api.dto.MileStoneDTO;
import com.nhnacademy.mini_dooray.task_api.entity.MileStone;
import com.nhnacademy.mini_dooray.task_api.entity.Project;
import com.nhnacademy.mini_dooray.task_api.repository.MileSoneRepository;
import com.nhnacademy.mini_dooray.task_api.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MileStoneService {

    private final MileSoneRepository mileStoneRepository;
    private final ProjectRepository projectRepository;

    /**
     * 마일스톤 생성
     *
     * @param mileStoneDTO
     * @return
     */
    public MileStoneDTO createMileStone(MileStoneDTO mileStoneDTO) {
        Project projectId = projectRepository.findById(mileStoneDTO.getProjectId())
                .orElseThrow(() -> new IllegalArgumentException("Project Not Found"));

        MileStone mileStone = new MileStone(projectId, mileStoneDTO.getMileStoneName(), mileStoneDTO.getMileStoneStartDate(), mileStoneDTO.getMileStoneEndDate());

        MileStone savedMileStone = mileStoneRepository.save(mileStone);

        return new MileStoneDTO(savedMileStone.getProjectId().getProjectId(),
                savedMileStone.getMileStoneName(), savedMileStone.getMileStoneStartDate(), savedMileStone.getMileStoneEndDate());
    }
}
