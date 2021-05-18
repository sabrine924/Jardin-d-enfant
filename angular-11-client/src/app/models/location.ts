export interface Location {
   country :string
   data : Marker
    /*latitude: number;
    longitude: number;
    zoom: number;
    isFullScreen: boolean;
    mapType?: string;*/
}

export interface Marker {
    lat: number;
    lng: number;
}