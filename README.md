package com.hospital.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.hospital.dto.EmergencyAdmissionDTO;
import com.hospital.dto.EmergencyAdmissionRespDTO;
import com.hospital.entites.EmergencyAdmission;
import com.hospital.exceptions.ResourceNotFoundException;
import com.hospital.repository.EmergencyAdmissionRespositary;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class EmergencyAdmissionServiceImpl implements EmergencyAdmissionService {
	
	private final EmergencyAdmissionRespositary repo;
	private final ModelMapper mapper;

	@Override
	public EmergencyAdmissionRespDTO addAdmission(EmergencyAdmissionDTO dto) {
		EmergencyAdmission admission = mapper.map(dto, EmergencyAdmission.class);
		EmergencyAdmission saved = repo.save(admission);
		
		return mapper.map(saved, EmergencyAdmissionRespDTO.class);
	}

	@Override
	public EmergencyAdmissionRespDTO updateAdmission(Long id, EmergencyAdmissionDTO dto) {
		EmergencyAdmission oldAdmission = repo.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Wrong"));
		mapper.map(dto, oldAdmission);
		return mapper.map(oldAdmission, EmergencyAdmissionRespDTO.class);
	}

	@Override
	public EmergencyAdmissionRespDTO getAdmission(Long id) {
		EmergencyAdmission admission = repo.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Wrong"));
		return mapper.map(admission, EmergencyAdmissionRespDTO.class);
	}

	@Override
	public List<EmergencyAdmissionRespDTO> getAllAdmission() {
		return repo.findAll()
				.stream()
				.map(m-> mapper.map(m, EmergencyAdmissionRespDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<EmergencyAdmissionRespDTO> getCriticalPatient() {
		return repo.findByCritical(true)
				.stream()
				.map(m->mapper.map(m, EmergencyAdmissionRespDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public String getDelete(Long id) {
		repo.deleteById(id);
		return "Deleted Succeesully";
	}

}
