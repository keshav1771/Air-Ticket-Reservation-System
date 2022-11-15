import React from "react";
import { Link } from "react-router-dom";
import Footer from "./Footer";

function Page(){
    return(
        <div>
            <div className="container">
                <div className="row">
                    <div className="col-lg-12 p-0">
                        <div id="carouselExampleIndicators" className="carousel slide" data-ride="carousel">
                            <ol className="carousel-indicators">
                                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                            </ol>
                            <div className="carousel-inner">
                                <div className="carousel-item active">
                                    <img className="d-block" src="https://d3mvlb3hz2g78.cloudfront.net/wp-content/uploads/2016/02/thumb_720_450_f_12.jpg" width="1300" height="650" alt="First slide" />
                                    <Link to={{pathname: "/scheduleFlight/search"}}>
                                    <div className="carousel-caption d-none d-md-block">
                                        <h3>Search and book best flights here</h3>
                                        <p>At GSK Airlines, we offer you the best tickets to not only fly on-time but to also enjoy hassle-free and courteous service on board and beyond.</p>
                                    </div>
                                    </Link>
                                </div>
                                <div className="carousel-item">
                                    <img className="d-block" src="https://i.pinimg.com/originals/ec/05/db/ec05dbb5deb17a06d30ee83f7b98d3f5.jpg" width="1140" height="650" alt="Second slide" />
                                    <Link to={{pathname: "/login"}}>
                                    <div className="carousel-caption d-none d-md-block">
                                        <h3>Avail premium services on domestic flights</h3>
                                        <p>Upgrade your flying experience with a host of convenient services and priority privileges.</p>
                                    </div>
                                    </Link>
                                </div>
                                <div className="carousel-item">
                                    <img className="d-block" src="https://c4.wallpaperflare.com/wallpaper/945/450/537/flying-planes-aviation-pilot-simulator-hd-wallpaper-preview.jpg" width="1140" height="650" alt="Third slide" />
                                    <div className="carousel-caption d-none d-md-block ">
                                        <h3>Cheapest domestic tickets</h3>
                                        <p>GSK Airlines provides great offers, competitive airfares, and a seamless online booking experience to many of its customers.</p>
                                    </div>
                                </div>
                            </div>
                            <a className="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                            <span className="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span className="sr-only">Previous</span>
                            </a>
                            <a className="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                            <span className="carousel-control-next-icon" aria-hidden="true"></span>
                            <span className="sr-only">Next</span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <Footer />
        </div>
    );
}

export default Page;




