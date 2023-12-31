import React from "react";
import {
  Dialog,
  DialogTitle,
  DialogContent,
  DialogActions,
  Typography,
  Button,
} from "@mui/material";
import { useNavigate } from "react-router-dom";



export default function ConfirmationModal({
  open,
  handleClose,
  userData, // This should be an object containing the user's entered data
}) {
  const navigate = useNavigate(); // Initialize useHistory

  // Function to handle the confirmation and navigation
  const handleConfirmation = () => {
    // Handle appointment confirmation and bill generation here
    handleClose();
    // Navigate to the appointments page
    navigate("/user/appointment");
  };
  return (
    <Dialog open={open} onClose={handleClose}>
      <DialogTitle>
        <strong>Confirm Appointment</strong> - Upon Service, Bill will be available in the My Bookings Section.
      </DialogTitle>
      <DialogContent>
        <Typography variant="h6">Confirmation Details:</Typography>
        <Typography variant="body1">
          <strong>Name:</strong> {userData.enterProductName}
        </Typography>
        <Typography variant="body1">
          <strong>Model Number:</strong> {userData.enterModelNo}
        </Typography>
        <Typography variant="body1">
          <strong>Date of Purchase:</strong> {userData.enterDateOfPurchase}
        </Typography>
        <Typography variant="body1">
          <strong>Contact Number:</strong> {userData.enterContactNumber}
        </Typography>
        <Typography variant="body1">
          <strong>Problem:</strong> {userData.enterProblem}
        </Typography>
        <Typography variant="body1">
          <strong>Appointment Date:</strong> {userData.enterAppointmentDate}
        </Typography>
      </DialogContent>
      <DialogActions>
        <Button onClick={handleClose} color="primary">
          Cancel
        </Button>
          <Button color="primary" onClick={handleConfirmation}> {/* Correct the placement */}
            Confirm
          </Button>
      </DialogActions>
    </Dialog>
  );
}
