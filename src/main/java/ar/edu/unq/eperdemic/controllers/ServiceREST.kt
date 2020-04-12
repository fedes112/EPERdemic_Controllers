package ar.edu.unq.eperdemic.controllers

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RestController


@RestController
@CrossOrigin(origins = ["http://localhost:3000", "https://heventeando.herokuapp.com"])
annotation class ServiceREST