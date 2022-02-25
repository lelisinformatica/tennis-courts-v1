package com.tenniscourts.guests;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@AllArgsConstructor
@RestController
@RequestMapping(value = "/tennis-court/guests", produces = { MediaType.APPLICATION_JSON_VALUE })
public class GuestController {

    @Autowired
    private GuestService guestService;

    @ApiOperation(value = "Create a Guest.",
            notes = "creating a new guest record")
    @PostMapping
    public ResponseEntity<GuestDTO> createGuest(@RequestBody GuestDTO dto){
        return (ResponseEntity<GuestDTO>) ResponseEntity.ok(guestService.createGuest(dto));
    }

    @ApiOperation(value = "Update a Guest.",
            notes = "updating a guest record")
    @PutMapping("/{id}")
    public ResponseEntity<GuestDTO>  updateGuest(
            @PathVariable Long id,
            @RequestBody GuestDTO dto){
        return (ResponseEntity<GuestDTO>) ResponseEntity.ok(guestService.updateGuest(id, dto));
    }

    @ApiOperation(value = "Delete a Guest.",
            notes = "deleting a guest record")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuest(@PathVariable Long id){
        return (ResponseEntity<Void>) ResponseEntity.ok(guestService.deleteGuest(id));
    }

    @ApiOperation(value = "List all guests.",
            notes = "list all guest records")
    @GetMapping
    public ResponseEntity<List<GuestDTO>> getAll(){
        return ResponseEntity.ok(guestService.getAll());
    }

    @ApiOperation(value = "Find a guest.",
            notes = "Find guest record, by name")
    @GetMapping("/guest")
    public ResponseEntity<GuestDTO> findByName(@RequestParam(name = "name", required = true) String name) {
        return ResponseEntity.ok(guestService.findByName(name));
    }

    @ApiOperation(value = "Get a guests.",
            notes = "Get guest record, by id")
    @GetMapping("/{id}")
    public ResponseEntity<GuestDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(guestService.findById(id));
    }



}
