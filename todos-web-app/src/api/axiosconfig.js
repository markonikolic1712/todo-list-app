import axios, { AxiosRequestConfig } from "axios";

const BASE_URL = "http://localhost:8080/api/todo";

async function GET(path) {
  try {
    console.log("axiosconfig.js => Salje se GET request za celu listu");
    const response = await axios.get(BASE_URL + path);

    if (response.data) return response.data;
  } catch (error) {
    throw new Error(error.message);
  }
}

async function PUT(path, data) {
  try {
    const jsonData = JSON.stringify(data);
    const axiosConfig = {
      method: "PUT",
      url: BASE_URL + path,
      headers: {
        "Content-Type": "application/json",
      },
      data: jsonData,
    };

    const response = await axios(axiosConfig);
    if (response.status === 200 && response.data) return response.data;
  } catch (error) {
    throw new Error(error.message);
  }
}

async function POST(path, data) {
  try {
    const jsonData = JSON.stringify(data);
    const axiosConfig = {
      method: "POST",
      url: BASE_URL + path,
      headers: {
        "Content-Type": "application/json",
      },
      data: jsonData,
    };

    const response = await axios(axiosConfig);
    if (response.status === 201 && response.data) return response.data;
  } catch (error) {
    throw new Error(error.message);
  }
}

// DELETE se ne koristi - kada korisnik hoce da izbrise todo iz liste u bazi se uradi update kolone deleted_at na datum i vreme brisanja i taj red ostaje u bazi ali se ne brise
// podatak o trenutku brisanja se upisuje u todo objekat na backendu

const api = { GET, PUT, POST };

export default api;
