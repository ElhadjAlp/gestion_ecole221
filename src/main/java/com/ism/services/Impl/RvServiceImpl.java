
package com.ism.services.Impl;

import java.util.List;
import com.ism.data.entites.Medecin;
import com.ism.data.entites.Rv;
import com.ism.data.repository.RvRepository;
import com.ism.services.RvService;

public class RvServiceImpl implements RvService {

  private static final Medecin Medecin = null;
  private RvRepository userRepository;


  public RvServiceImpl(RvRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void createRv(Rv rv) {
    userRepository.insert(Medecin );
  }

  @Override
  public List<Medecin> findAllRv() {
    return userRepository.selectAll();
  }

  @Override
  public List<com.ism.data.entites.Medecin> findAllMedecins() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findAllMedecins'");
  }

}
