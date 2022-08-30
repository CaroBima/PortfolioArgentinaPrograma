/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { TecnologiasService } from './tecnologias.service';

describe('Service: Tecnologias', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TecnologiasService]
    });
  });

  it('should ...', inject([TecnologiasService], (service: TecnologiasService) => {
    expect(service).toBeTruthy();
  }));
});
