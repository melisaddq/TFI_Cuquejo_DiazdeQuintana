package ar.edu.utn.tupad.sigcoin.infrastructure.controllers;

import ar.edu.utn.tupad.sigcoin.domain.model.Usuario;
import ar.edu.utn.tupad.sigcoin.infrastructure.services.externos.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/usuarios/{email}")
    public ResponseEntity<Usuario> getUsuarioPorEmail(@PathVariable String email) {
        return ResponseEntity.ok(usuarioService.getUsuarioPorEmail(email));
    }
}
