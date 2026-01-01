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










package com.airport.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.airport.dto.PassengerEntryDTO;
import com.airport.dto.PassengerEntryRespDTO;
import com.airport.entities.EntryStatus;
import com.airport.entities.PassengerEntry;
import com.airport.exceptions.ResourceNotFoundException;
import com.airport.repository.PassengerEntryRepo;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class PassengerEntryServiceImply implements PassengerEntryService {
	
	private final PassengerEntryRepo repo;
	private final ModelMapper mapper;

	@Override
	public PassengerEntryRespDTO addEntry(PassengerEntryDTO dto) {
		PassengerEntry entry = mapper.map(dto, PassengerEntry.class);
		PassengerEntry saved = repo.save(entry);
		return mapper.map(saved, PassengerEntryRespDTO.class);
	}

	@Override
	public PassengerEntryRespDTO updateEntry(Long id, PassengerEntryDTO dto) {
		PassengerEntry entry = repo.findById(id)
				.orElseThrow( () -> new ResourceNotFoundException("Entry Not found"));
		mapper.map(dto, entry);
		return mapper.map(entry, PassengerEntryRespDTO.class);
	}

	@Override
	public PassengerEntryRespDTO getEntry(Long id) {
		PassengerEntry entry = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Entry Not Found"));
		return mapper.map(entry, PassengerEntryRespDTO.class);
	}

	@Override
	public List<PassengerEntryRespDTO> getAllEntries() {
		return repo.findAll()
				.stream()
				.map(m -> mapper.map(m, PassengerEntryRespDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<PassengerEntryRespDTO> getActiveEntreis() {
		return repo.findByEntryStatus(EntryStatus.ENTERED).stream().map(m->mapper.map(m, PassengerEntryRespDTO.class)).collect(Collectors.toList())
		;		
	}

	@Override
	public String deleteEntry(Long id) {
		repo.deleteById(id);
		return "Deleted success"; 
	}

}
