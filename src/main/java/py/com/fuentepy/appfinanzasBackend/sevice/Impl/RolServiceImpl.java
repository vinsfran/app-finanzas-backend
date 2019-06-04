package py.com.fuentepy.appfinanzasBackend.sevice.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import py.com.fuentepy.appfinanzasBackend.entity.Rol;
import py.com.fuentepy.appfinanzasBackend.repository.RolRepository;
import py.com.fuentepy.appfinanzasBackend.sevice.RolService;

import java.util.List;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository rolRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Rol> findAll() {
        return (List<Rol>) rolRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Rol> findAll(Pageable pageable) {
        return rolRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Rol findById(Long id) {
        return rolRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Rol save(Rol cliente) {
        return rolRepository.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        rolRepository.deleteById(id);
    }
}
