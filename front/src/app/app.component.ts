import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { CandidatesService } from './services/candidates.service';
import { Candidates } from './models/candidates.mode';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'front';

  candidate: Candidates = { cedula: '', nombre: '', binomio: '' };
  cedulaBuscar: string = '';
  cedula: string = ''; // Cédula ingresada por el usuario
  usuarioData: any = null; // Datos del usuario obtenidos del servicio
  error: string | null = ''; // Mensaje de error en caso de fallo

  constructor(private candidateService: CandidatesService) { }

  consultar() {
    this.candidateService.getUsuarioData(this.cedula).subscribe(
      data => {
        this.usuarioData = data; // Asigna los datos del usuario
        this.error = ''; // Limpia el mensaje de error
      },
      error => {
        this.error = 'Candidato no encontrado'; // Establece un mensaje de error
        this.usuarioData = null; // Limpia los datos del usuario
      }
    );
  }

  crearCandidate() {
    this.candidateService.createCandidate(this.candidate).subscribe();
  }



}
